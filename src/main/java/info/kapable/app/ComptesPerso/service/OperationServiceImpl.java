package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.OperationDAO;
import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;
@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	protected OperationDAO operationDAO;

	@Override
	public Operation getOperation(Long id) {
		return this.operationDAO.findOne(id);
	}

	@Override
	public void updateOperation(Operation operation) {
		this.operationDAO.save(operation);
	}

	@Override
	public Operation save(Operation operation) {
		Operation opeReturn = this.operationDAO.save(operation);
		this.operationDAO.flush();
		return opeReturn;
	}

	@Override
	public List<Operation> getOperations() {
		return this.operationDAO.findAll();
	}

	@Override
	public List<Operation> getOperationsForAccount(Account a) {
		return this.operationDAO.getOperationsFromAccount(a);
	}

	@Override
	public Operation get(Long id) {
		return this.operationDAO.findOne(id);
	}
}
