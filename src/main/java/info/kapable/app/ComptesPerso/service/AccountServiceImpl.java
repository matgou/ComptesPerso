package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import info.kapable.app.ComptesPerso.dao.AccountDAO;
import info.kapable.app.ComptesPerso.pojo.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	protected AccountDAO accountDAO;

	@Override
	public List<Account> getAccountForUser(String username) {
		return this.accountDAO.findAll();
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
