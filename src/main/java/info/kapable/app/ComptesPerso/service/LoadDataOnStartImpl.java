package info.kapable.app.ComptesPerso.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Category;

@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class LoadDataOnStartImpl implements LoadDataOnStart {

	private static Logger logger = Logger.getLogger(LoadDataOnStartImpl.class);
	
	@Autowired
	protected CategoryService categoryService;
	
	@PostConstruct
	public void init(){
		if(this.categoryService.getNbCategory() <= 0) {
			try {
				this.loadCategory();
			} catch (NumberFormatException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (NullPointerException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
	}

	private void loadCategory() throws NumberFormatException, IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("category.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        Map<Integer,Category> categoryMap = new HashMap<Integer,Category>();
		while ((line = br.readLine()) != null) {
        	String[] field = line.split(",");
        	Category c = new Category();
        	if(field[1].contains("true")) {
        		c.setCategoryDebit(true);
        	} else {
        		c.setCategoryDebit(false);
        	}
        	c.setLabel(field[2].replaceAll("^'", "").replaceAll("'$", ""));
        	Integer id = Integer.parseInt(field[0].replaceAll(" ", ""));
        	categoryMap.put(id, c);
        	if(!field[3].contains("NULL")) {
        		Integer parentId = Integer.parseInt(field[3].replaceAll(" ", ""));
        		c.setParent(categoryMap.get(parentId));
        	}
        	this.categoryService.save(c);
        }
	}
}
