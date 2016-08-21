package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;

/**
 * Service to access on transaction ressources
 * @author matgou
 */
public interface OperationService {

	/**
	 * Return the transaction of given id
	 * 
	 * @param id
	 * @return
	 */
	public Operation getTransaction(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateTransaction(Operation operation);

	/**
	 * Basic save trasaction
	 * @param t
	 * @return 
	 */
	public Operation save(Operation t);

	public List<Operation> getTransactions();

	public List<Operation> getTransactionsForAccount(Account a);

	public Operation get(Long id);
}
