package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Category;

public interface BasicService<T> {

	/**
	 * Return all object
	 * @return
	 */
	public abstract List<T> getAll();
	
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

}
