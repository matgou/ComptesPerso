package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;
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
	 * @return 
	 */
	public Transaction save(Transaction t);

	public List<Transaction> getTransactions();

	public List<Transaction> getTransactionsForAccount(Account a);

	public Transaction get(Long id);
}
