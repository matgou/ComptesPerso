package info.kapable.app.ComptesPerso.controller;

import java.util.List;

public abstract class CrudController<T> {

	/**
	 * Get all accessible object from current context
	 * 
	 * @return
	 */
    public abstract List<T> list();
    
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

	public abstract void delete(Long id);
}
