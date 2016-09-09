package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.service.CategoryService;

/**
 * This controller manipulate category
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@RequestMapping("/category")
@RestController
public class CategoryController extends CrudController<Category> {

	private static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
    @RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<Category> list() {
		logger.debug("Get all category");
		return this.categoryService.getAll();
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable("id") Long id) {
		logger.debug("Get category id=" + id);
		return this.categoryService.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Category save(@RequestBody Category o) {
		logger.debug("Save category id=" + o.getId());
		return this.categoryService.save(o);
	}

	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		logger.debug("delete category id=" + id);
		this.categoryService.remove(this.get(id));
	}
}
