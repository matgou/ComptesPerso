package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Transaction;
import info.kapable.app.ComptesPerso.dao.TransactionDAO;
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	protected TransactionDAO transactionDAO;

	@Override
	public Transaction getTransaction(Long id) {
		return this.transactionDAO.findOne(id);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		this.transactionDAO.save(transaction);
	}

	@Override
	public Transaction save(Transaction transaction) {
		return this.transactionDAO.save(transaction);
	}

	@Override
	public List<Transaction> getTransactions() {
		return this.transactionDAO.findAll();
	}

	@Override
	public List<Transaction> getTransactionsForAccount(Account a) {
		return this.transactionDAO.getTransactionsFromAccount(a);
	}

	@Override
	public Transaction get(Long id) {
		return this.transactionDAO.findOne(id);
	}
}
