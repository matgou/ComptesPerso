package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Home;
import info.kapable.app.ComptesPerso.pojo.Transaction;

@Repository
public class TransactionDAOImpl extends AbstractDAO<Transaction> implements TransactionDAO {

	@Override
	@Transactional
	public Transaction get(Long id) {
		return this.sessionFactory.getCurrentSession().load(Transaction.class, id);
	}

	@Override
	public List<Transaction> getAll() {
		List<Transaction> list = this.sessionFactory.getCurrentSession().createCriteria(Transaction.class).list();
		return list;
	}
}
