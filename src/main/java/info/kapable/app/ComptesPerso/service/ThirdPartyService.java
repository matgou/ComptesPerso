package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.ThirdParty;

public interface ThirdPartyService {

	/**
	 * Return the transaction of given id
	 * 
	 * @param id
	 * @return
	 */
	public ThirdParty getThirdParty(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateThirdParty(ThirdParty thirdParty);

	/**
	 * Basic save trasaction
	 * @param t
	 * @return 
	 */
	public ThirdParty save(ThirdParty t);

	public List<ThirdParty> getThirdParties();

	public ThirdParty get(Long id);

}
