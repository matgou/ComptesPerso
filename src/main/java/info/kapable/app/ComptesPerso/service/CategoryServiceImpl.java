package info.kapable.app.ComptesPerso.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.CategoryDAO;
import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@Service
public class CategoryServiceImpl extends CategoryService {
    
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	protected CategoryDAO categoryDAO;
	
	@Override
	public Page<Category> getAll() {
		return this.getAll(1, 10);
	}
	
	public Page<Category> getAll(int pageSize, int pageNumber) {
		PageRequest page = new PageRequest(pageSize, pageNumber);
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
