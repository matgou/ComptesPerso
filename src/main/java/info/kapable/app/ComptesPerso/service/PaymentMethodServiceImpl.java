package info.kapable.app.ComptesPerso.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import info.kapable.app.ComptesPerso.dao.PaymentMethodDAO;
import info.kapable.app.ComptesPerso.pojo.PaymentMethod;

@Service
public class PaymentMethodServiceImpl extends PaymentMethodService {

	@Autowired
	protected PaymentMethodDAO paymentMethodDAO;

	public Page<PaymentMethod> getAll() {
		return this.getAll(0, 10);
	}
	
	public Page<PaymentMethod> getAll(int pageNumber, int pageSize) {
		PageRequest page = new PageRequest(pageNumber, pageSize);
		return this.paymentMethodDAO.findAll(page);
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
	
	@Override
	public Page<PaymentMethod> find(int pageSize, int pageNumber, Map<String, Object> criterias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbPaymentMethod() {
		return this.paymentMethodDAO.getNbPaymentMethod();
	}

	@Override
	public List<PaymentMethod> findAll() {
		return this.paymentMethodDAO.findAll();
	}
}
