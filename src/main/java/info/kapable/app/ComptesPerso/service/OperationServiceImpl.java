package info.kapable.app.ComptesPerso.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.OperationDAO;
import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;
@Service
public class OperationServiceImpl extends OperationService {

	@Autowired
	protected OperationDAO operationDAO;

	public Operation save(Operation operation) {
		Operation opeReturn = this.operationDAO.save(operation);
		this.operationDAO.flush();
		return opeReturn;
	}

	public List<Operation> getOperationsForAccount(Account a) {
		return this.operationDAO.getOperationsFromAccount(a);
	}

	public Operation get(Long id) {
		return this.operationDAO.findOne(id);
	}

	@Override
	public void remove(Operation o) {
		this.operationDAO.delete(o);
	}

	@Override
	public Page<Operation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Operation> getAll(int pageSize, int pageNumber) {
		return null;
	}

	@Override
	public Page<Operation> find(int pageSize, int pageNumber, Map<String, Object> criterias) {
		// TODO Auto-generated method stub
		return null;
	}
}
