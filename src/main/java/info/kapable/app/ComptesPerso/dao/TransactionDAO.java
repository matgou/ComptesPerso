package info.kapable.app.ComptesPerso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {
}
