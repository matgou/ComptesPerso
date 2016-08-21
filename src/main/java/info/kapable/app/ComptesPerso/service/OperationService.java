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
	public Operation getOperation(Long id);

	/**
	 * Update a foyer
	 * 
	 * @param foyer
	 */
	public void updateOperation(Operation operation);

	/**
	 * Basic save trasaction
	 * @param t
	 * @return 
	 */
	public Operation save(Operation t);

	public List<Operation> getOperations();

	public List<Operation> getOperationsForAccount(Account a);

	public Operation get(Long id);
}
