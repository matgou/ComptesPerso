package info.kapable.app.ComptesPerso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.AccountDAO;
import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;
import info.kapable.app.ComptesPerso.pojo.Category;

@Service
public class AccountServiceImpl extends AccountService {

	@Autowired
	protected AccountDAO accountDAO;

	public List<AccountWithBalance> getAccountForUser(String username) {
		List<AccountWithBalance> returnList = new ArrayList<AccountWithBalance>();
		List<Account> accountList = this.accountDAO.findAll();
		for(Account account: accountList)
		{
			AccountWithBalance accountWithBalance = new AccountWithBalance(account, this.getRealBalance(account), this.getPointedBalance(account));
			returnList.add(accountWithBalance);
		}
		return returnList;
	}

	public double getRealBalance(Account a) {
		Double returnValue = this.accountDAO.getRealBalance(a);
		if(returnValue == null) {
			return 0.;
		}
		return returnValue;
	}

	public double getPointedBalance(Account a) {
		Double returnValue = this.accountDAO.getPointedBalance(a);
		if(returnValue == null) {
			return 0.;
		}
		return returnValue;
	}

	@Override
	public Page<Account> getAll() {
		return this.getAll(0, 10);
	}

	public Page<Account> getAll(int pageNumber, int pageSize) {
		PageRequest page = new PageRequest(pageNumber, pageSize);
		return this.accountDAO.findAll(page);
	}
	
	@Override
	public Account get(Long id) {
		return this.accountDAO.findOne(id);
	}

	@Override
	public Account save(Account o) {
		return this.accountDAO.save(o);
	}

	@Override
	public void remove(Account o) {
		this.accountDAO.delete(o);
	}

	@Override
	public Page<Account> find(int pageSize, int pageNumber, Map<String, Object> criterias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbAccount() {
		return this.accountDAO.getNbAccount();
	}

	@Override
	public List<Account> findAll() {
		return this.accountDAO.findAll();
	}
}
