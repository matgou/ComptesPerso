package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;
import info.kapable.app.ComptesPerso.dao.OperationDAO;
@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	protected OperationDAO operationDAO;

	@Override
	public Operation getTransaction(Long id) {
		return this.operationDAO.findOne(id);
	}

	@Override
	public void updateTransaction(Operation operation) {
		this.operationDAO.save(operation);
	}

	@Override
	public Operation save(Operation operation) {
		return this.operationDAO.save(operation);
	}

	@Override
	public List<Operation> getTransactions() {
		return this.operationDAO.findAll();
	}

	@Override
	public List<Operation> getTransactionsForAccount(Account a) {
		return this.operationDAO.getTransactionsFromAccount(a);
	}

	@Override
	public Operation get(Long id) {
		return this.operationDAO.findOne(id);
	}
}
