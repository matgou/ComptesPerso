package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import info.kapable.app.ComptesPerso.pojo.Pojo;
import info.kapable.app.ComptesPerso.pojo.Transaction;

public interface TransactionDAO {

	void save(Pojo o);

	List<Transaction> getAll();

	Transaction get(Long id);
}
