package info.kapable.app.ComptesPerso.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.PaymentMethod;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class LoadDataOnStartImpl implements LoadDataOnStart {

	private static Logger logger = Logger.getLogger(LoadDataOnStartImpl.class);
	
	@Autowired
	protected CategoryService categoryService;
	
	@Autowired
	protected AccountService accountService;
	
	@Autowired
	protected ThirdPartyService thirdPartyService;
	
	@Autowired
	protected PaymentMethodService paymentMethodService;
	
	@PostConstruct
	public void init(){
		if(this.accountService.getNbAccount() <= 0) {
			this.loadAccount();
		}
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

		if(this.thirdPartyService.getNbThirdParty() <= 0) {
			try {
				this.loadThirdParty();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		if(this.paymentMethodService.getNbPaymentMethod() <= 0) {
			try {
				this.loadPaymentMethod();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
	}

	private void loadPaymentMethod() throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("data/PaymentMethod.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
		while ((line = br.readLine()) != null) {
        	String[] field = line.split(",");
        	PaymentMethod p = new PaymentMethod();
        	p.setLabel(field[0].replaceAll("^'", "").replaceAll("'$", ""));
        	this.paymentMethodService.save(p);
		}
	}

	private void loadThirdParty() throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("data/thirdParty.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
		while ((line = br.readLine()) != null) {
        	String[] field = line.split(",");
        	ThirdParty t = new ThirdParty();
        	t.setLabel(field[1].replaceAll("^'", "").replaceAll("'$", ""));
        	this.thirdPartyService.save(t);
		}
	}

	private void loadAccount() {
		Account a = new Account();
		a.setEnable(true);
		a.setLabel("Compte COURRANT");
		a.setIntialValue(0.);
		a.setType(Account.TYPE_COMPTE_COURANT);
		this.accountService.save(a);
		
		Account a2 = new Account();
		a2.setEnable(true);
		a2.setLabel("Compte Epargne");
		a2.setIntialValue(0.);
		a2.setType(Account.TYPE_EPARGNE_DISPO);
		this.accountService.save(a2);
	}

	private void loadCategory() throws NumberFormatException, IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("data/category.csv");

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
