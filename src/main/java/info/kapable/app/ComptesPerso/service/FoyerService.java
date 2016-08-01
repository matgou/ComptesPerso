package info.kapable.app.ComptesPerso.service;

import info.kapable.app.ComptesPerso.pojo.Foyer;

/**
 * Service to access on foyer ressources
 * @author matgou
 */
public interface FoyerService {

	/**
	 * Create a new foyer from string
	 * 
	 * @param name
	 * @return the new foyer
	 */
	public Foyer newFoyer(String name);

	/**
	 * Return the foyer of given id
	 * 
	 * @param id
	 * @return
	 */
	public Foyer getFoyer(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateFoyer(Foyer foyer);
}
