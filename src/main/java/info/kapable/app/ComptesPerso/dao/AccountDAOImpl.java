package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Foyer;

@Repository
public class AccountDAOImpl extends AbstractDAO<Account> implements AccountDAO {

	@Override
	public List<Account> getAll() {
		List<Account> list = this.sessionFactory.getCurrentSession().createCriteria(Account.class).list();
		return list;
	}

	@Override
	public Account get(Long id) {
		return this.sessionFactory.getCurrentSession().load(Account.class, id);
	}
}
