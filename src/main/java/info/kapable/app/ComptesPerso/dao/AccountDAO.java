package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
	
	@Query(value = "SELECT ( SELECT COALESCE(sum(o.credit),0) - COALESCE(sum(o.debit),0) FROM Operation o WHERE o.account=a ) + a.intialValue FROM Account a WHERE a = :account")
	public Double getRealBalance(@Param("account") Account a);
	
	@Query(value = "SELECT ( SELECT COALESCE(sum(o.credit),0) - COALESCE(sum(o.debit),0) FROM Operation o WHERE o.account=a AND o.pointedTransaction = true ) + a.intialValue FROM Account a WHERE a = :account")
	public Double getPointedBalance(@Param("account") Account a);
}
