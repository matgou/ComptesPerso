package info.kapable.app.ComptesPerso.service;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Expression;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.Operation;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

public interface BasicService<T> {

	/**
	 * Return all object
	 * @return
	 */
	Page<T> getAll();
	Page<T> getAll(int pageNumber, int pageSize);
		
	/**
	 * Return object of given id
	 * @param id
	 * @return
	 */
	public abstract T get(Long id);

	/**
	 * Save object and return it
	 * @param o
	 * @return
	 */
	public abstract T save(T o);

	/**
	 * delete object
	 * @return
	 */
	public abstract void remove(T o);

	/**
	 * Find object with given label
	 * @param searchLabel
	 * @return
	 */
	// public abstract 
	Page<T> find(int pageSize, int pageNumber, Map<String, Object> criterias);
}
