package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {
	@Query(value = "SELECT t FROM Transaction t INNER JOIN t.account a WHERE a = :account")
	public List<Transaction> getTransactionsFromAccount(@Param("account") Account a);
}
