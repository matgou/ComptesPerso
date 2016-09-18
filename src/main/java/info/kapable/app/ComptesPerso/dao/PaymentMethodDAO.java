package info.kapable.app.ComptesPerso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info.kapable.app.ComptesPerso.pojo.PaymentMethod;

@Repository
public interface PaymentMethodDAO extends JpaRepository<PaymentMethod, Long> {

	@Query(value="SELECT COUNT(*) FROM PaymentMethod pm")
	public int getNbPaymentMethod();
}
