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
import info.kapable.app.ComptesPerso.service.AccountService;

/**
 * This controller manipulate account resource
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@RequestMapping("/accounts")
@RestController
public class AccountController extends CrudController<Account> {
	
	private static Logger logger = Logger.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	@Override
    @RequestMapping(value="/accounts", method = RequestMethod.GET)
    public List<Account> list() {
    	List<Account> accounts = this.accountService.getAccountForUser("matgou");
    	return accounts;
    }
    
    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Account save(@RequestBody Account account) {
		logger.info("Save account " + account);
    	this.accountService.save(account);
    	return account;
    }
    
	@Override
    @RequestMapping("/{id}")
	public Account get(@PathVariable("id") Long id) {
		return this.accountService.get(Long.valueOf(id));
	}
}
