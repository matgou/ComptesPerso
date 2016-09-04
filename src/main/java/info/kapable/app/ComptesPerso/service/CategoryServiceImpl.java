package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.CategoryDAO;
import info.kapable.app.ComptesPerso.pojo.Category;

@Service
public class CategoryServiceImpl extends CategoryService {
    
	@Autowired
	protected CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAll() {
		return this.categoryDAO.findAll();
	}

	@Override
	public Category get(Long id) {
		return this.categoryDAO.findOne(id);
	}

	@Override
	public Category save(Category o) {
		return this.categoryDAO.save(o);
	}

	@Override
	public long getNbCategory() {
		return this.categoryDAO.count();
	}

}
