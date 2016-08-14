package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;

/**
 * Service to access on account ressources
 * @author matgou
 */
public interface AccountService {

	List<Account> getAccountForUser(String username);

	Account get(Long id);

	void save(Account a);

	double getRealBalance(Account a);

	double getPointedBalance(Account a);
}
