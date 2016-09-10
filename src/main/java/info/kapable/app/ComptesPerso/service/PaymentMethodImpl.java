package info.kapable.app.ComptesPerso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import info.kapable.app.ComptesPerso.dao.PaymentMethodDAO;
import info.kapable.app.ComptesPerso.pojo.PaymentMethod;

@Service
public class PaymentMethodImpl extends PaymentMethodService {

	@Autowired
	protected PaymentMethodDAO paymentMethodDAO;

	@Override
	public List<PaymentMethod> getAll() {
		return this.paymentMethodDAO.findAll();
	}

	@Override
	public PaymentMethod get(Long id) {
		return this.paymentMethodDAO.findOne(id);
	}

	@Override
	public PaymentMethod save(PaymentMethod o) {
		return this.paymentMethodDAO.save(o);
	}

	@Override
	public void remove(PaymentMethod o) {
		this.paymentMethodDAO.delete(o);
	}
}
