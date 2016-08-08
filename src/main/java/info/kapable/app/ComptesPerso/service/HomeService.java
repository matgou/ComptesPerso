package info.kapable.app.ComptesPerso.service;

import info.kapable.app.ComptesPerso.pojo.Home;

/**
 * Service to access on foyer ressources
 * @author matgou
 */
public interface HomeService {

	/**
	 * Create a new foyer from string
	 * 
	 * @param name
	 * @return the new foyer
	 */
	public Home newFoyer(String name);

	/**
	 * Return the foyer of given id
	 * 
	 * @param id
	 * @return
	 */
	public Home getFoyer(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateFoyer(Home foyer);
}
