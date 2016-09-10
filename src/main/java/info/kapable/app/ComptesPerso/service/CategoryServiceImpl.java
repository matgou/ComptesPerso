package info.kapable.app.ComptesPerso.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.CategoryDAO;
import info.kapable.app.ComptesPerso.pojo.Category;

@Service
public class CategoryServiceImpl extends CategoryService {
    
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	protected CategoryDAO categoryDAO;
	
	@Override
	public Page<Category> getAll() {
		return this.getAll(0, 10);
	}
	
	public Page<Category> getAll(int pageNumber, int pageSize) {
		PageRequest page = new PageRequest(pageNumber, pageSize);
		return this.categoryDAO.findAll(page);
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

	@Override
	public void remove(Category o) {
		this.categoryDAO.delete(o);
	}

	@Override
	public Page<Category> find(int pageSize, int pageNumber, Map<String, Object> criterias) {
		// TODO Auto-generated method stub
		return null;
	}
}
