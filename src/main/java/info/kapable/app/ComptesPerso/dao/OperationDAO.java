package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;

@Repository
public interface OperationDAO extends JpaRepository<Operation, Long> {
	@Query(value = "SELECT t FROM Operation t INNER JOIN t.account a WHERE a = :account")
	public List<Operation> getOperationsFromAccount(@Param("account") Account a);

	@Query(value = "SELECT t FROM Operation t WHERE t.description like :label")
	public List<Operation> findByLabel(@Param("label") String searchLabel);
}
