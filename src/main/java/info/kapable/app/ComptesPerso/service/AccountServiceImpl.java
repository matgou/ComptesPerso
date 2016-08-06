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
		return this.accountDAO.getAll();
	}

	@Override
	public Account get(Long id) {
		return this.accountDAO.get(id);
	}
}
