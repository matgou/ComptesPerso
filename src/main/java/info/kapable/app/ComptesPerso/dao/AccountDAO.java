package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
	
	@Query(value = "SELECT COALESCE(sum(t.credit),0) - COALESCE(sum(t.debit),0) + a.intialValue FROM Account a INNER JOIN a.transactions t WHERE a = :account")
	public Double getRealBalance(@Param("account") Account a);
	
	@Query(value = "SELECT COALESCE(sum(t.credit),0) - COALESCE(sum(t.debit),0) + a.intialValue FROM Account a INNER JOIN a.transactions t WHERE a = :account AND t.pointedTransaction = true")
	public Double getPointedBalance(@Param("account") Account a);
}
