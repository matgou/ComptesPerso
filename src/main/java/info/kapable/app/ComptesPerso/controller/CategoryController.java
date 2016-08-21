package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

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
		return this.categoryService.getAll();
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable("id") Long id) {
		return this.categoryService.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Category save(@RequestBody Category o) {
		return this.categoryService.save(o);
	}
}
