package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.PaymentMethod;
import info.kapable.app.ComptesPerso.service.PaymentMethodService;

@RequestMapping("/paymentMethod")
@RestController
public class PaymentMethodController extends CrudController<PaymentMethod> {

	private static Logger logger = Logger.getLogger(PaymentMethodController.class);

	@Autowired
	private PaymentMethodService paymentMethodService;
	
	@Override
    @RequestMapping(value="/paymentMethods", method = RequestMethod.GET)
	public List<PaymentMethod> list() {
		logger.debug("Get all paymentMethods");
		return paymentMethodService.getAll().getContent();
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PaymentMethod get(@PathVariable("id") Long id) {
		logger.debug("Get paymentMethods id=" + id );
		return paymentMethodService.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public PaymentMethod save(@Valid @RequestBody PaymentMethod o) {
		logger.debug("Save paymentMethods id=" + o.getId() );
		return paymentMethodService.save(o);
	}


	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		logger.debug("Delete paymentMethods id=" + id);
		paymentMethodService.remove(this.get(id));
	}

	@Override
	public List<PaymentMethod> search(String searchLabel) {
		// TODO Auto-generated method stub
		return null;
	}
}
