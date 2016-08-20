package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Transaction;
import info.kapable.app.ComptesPerso.service.AccountService;
import info.kapable.app.ComptesPerso.service.TransactionService;

/**
 * This controller manipulate trasaction or operation
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@RequestMapping("/transactions")
@RestController
public class OperationController extends CrudController<Transaction> {

	private static Logger logger = Logger.getLogger(OperationController.class);
	
	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;
	
	/**
	 * This function return transaction attached a given accountId
	 * @param accountId
	 * @return Transaction list
	 */
	@RequestMapping(value="/transactions/account/{accountId}", method = RequestMethod.GET)
	public List<Transaction> listForAccount(@PathVariable("accountId") Long accountId) {
		logger.info("Get transaction for account id = " + accountId);
		Account a = accountService.get(accountId);
		return this.transactionService.getTransactionsForAccount(a);
	}

	@Override
	@RequestMapping(value="/transactions/{id}", method = RequestMethod.GET)
	public Transaction get(@PathVariable("id") Long id) {
		return this.transactionService.get(id);
	}

	@Override
    @RequestMapping(method = RequestMethod.POST)
	public Transaction save(@RequestBody Transaction o) {
		return this.transactionService.save(o);
	}

	@Override
    @RequestMapping(value="/transactions", method = RequestMethod.GET)
	public List<Transaction> list() {
		return this.transactionService.getTransactions();
	}

}
