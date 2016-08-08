package info.kapable.app.ComptesPerso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void save(Transaction transaction) {
		this.transactionDAO.save(transaction);
	}
}
