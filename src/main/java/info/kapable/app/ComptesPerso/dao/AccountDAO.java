package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Account;

public interface AccountDAO {

	List<Account> getAll();

	Account get(Long id);
}
