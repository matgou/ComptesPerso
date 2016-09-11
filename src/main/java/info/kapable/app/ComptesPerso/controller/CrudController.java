package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import org.springframework.data.domain.Page;

public abstract class CrudController<T> {

	/**
	 * Get all accessible object from current context
	 * 
	 * @return
	 */
	public abstract Page<T> list(int pageNumber);
    
    /**
     * Return the object of given id
     * 
     * @param id
     * @return
     */
    public abstract T get(Long id);
    
    /**
     * Return the saved object
     * 
     * @param id
     * @return
     */
    public abstract T save(T o);

    /**
     * Delete an object with given id
     * 
     * @param id
     */
	public abstract void delete(Long id);

	/**
	 * Get operation with specified label
	 * 
	 * @param searchLabel
	 * @return
	 */
	public abstract List<T> search(String searchLabel);
}
