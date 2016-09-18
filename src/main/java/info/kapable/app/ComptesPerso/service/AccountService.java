package info.kapable.app.ComptesPerso.service;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;

/**
 * Service to access on account ressources
 * @author matgou
 */
public abstract class AccountService implements BasicService<Account>{

	public abstract List<AccountWithBalance> getAccountForUser(String username);
	
	public abstract double getRealBalance(Account a);

	public abstract double getPointedBalance(Account a);

	public abstract int getNbAccount();
}
