package info.kapable.app.ComptesPerso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Operation;
import info.kapable.app.ComptesPerso.service.AccountService;
import info.kapable.app.ComptesPerso.service.OperationService;

/**
 * This controller manipulate trasaction or operation
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@RequestMapping("/operations")
@RestController
public class OperationController extends CrudController<Operation> {

	private static Logger logger = Logger.getLogger(OperationController.class);
	
	@Autowired
	OperationService operationService;

	@Autowired
	AccountService accountService;
	
	/**
	 * This function return operations attached a given accountId
	 * @param accountId
	 * @return Operation list
	 */
	@RequestMapping(value="/account/{accountId}", method = RequestMethod.GET)
	public List<Operation> listForAccount(@PathVariable("accountId") Long accountId) {
		logger.info("Get Operation for account id = " + accountId);
		Account a = accountService.get(accountId);
		return this.operationService.getOperationsForAccount(a);
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Operation get(@PathVariable("id") Long id) {
		return this.operationService.get(id);
	}

	@Override
    @RequestMapping(method = RequestMethod.POST)
	public Operation save(@RequestBody Operation o) {
		return this.operationService.save(o);
	}

	@Override
    @RequestMapping(value="/operations", method = RequestMethod.GET)
	public Page<Operation> list(@RequestParam(value = "page", required=false, defaultValue = "1") int page) {
		return this.operationService.getAll(page-1, 10);
	}

	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		this.operationService.remove(this.get(id));
	}
	
	@Override
    @RequestMapping(value="/search", method = RequestMethod.GET)
	public List<Operation> search(@RequestParam(value = "label", required = false) String searchLabel) {
		Map<String, Object> criterias = new HashMap<String, Object>();
		criterias.put("label", searchLabel);
		return this.operationService.find(1, 10, criterias).getContent();
	}

}
