package info.kapable.app.ComptesPerso.service;

import info.kapable.app.ComptesPerso.pojo.Transaction;

/**
 * Service to access on transaction ressources
 * @author matgou
 */
public interface TransactionService {

	/**
	 * Return the transaction of given id
	 * 
	 * @param id
	 * @return
	 */
	public Transaction getTransaction(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateTransaction(Transaction transaction);

	/**
	 * Basic save trasaction
	 * @param t
	 */
	public void save(Transaction t);
}
