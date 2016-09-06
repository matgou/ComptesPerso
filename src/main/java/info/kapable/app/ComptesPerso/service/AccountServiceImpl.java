package info.kapable.app.ComptesPerso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kapable.app.ComptesPerso.dao.AccountDAO;
import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	protected AccountDAO accountDAO;

	@Override
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

	@Override
	public Account get(Long id) {
		return this.accountDAO.findOne(id);
	}

	@Override
	public void save(Account a) {
		this.accountDAO.save(a);
	}

	@Override
	public double getRealBalance(Account a) {
		Double returnValue = this.accountDAO.getRealBalance(a);
		if(returnValue == null) {
			return 0.;
		}
		return returnValue;
	}

	@Override
	public double getPointedBalance(Account a) {
		Double returnValue = this.accountDAO.getPointedBalance(a);
		if(returnValue == null) {
			return 0.;
		}
		return returnValue;
	}
}
