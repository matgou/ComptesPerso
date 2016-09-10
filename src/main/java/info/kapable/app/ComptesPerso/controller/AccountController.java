package info.kapable.app.ComptesPerso.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;
import info.kapable.app.ComptesPerso.pojo.Category;
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
	
	@RequestMapping(value="/accounts", method = RequestMethod.GET)
    public List<AccountWithBalance> listAll() {
    	List<AccountWithBalance> accounts = this.accountService.getAccountForUser("matgou");
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

	@Override
	public List<Account> list() {
    	List<AccountWithBalance> accounts = this.accountService.getAccountForUser("matgou");
    	ArrayList<Account> returnList = new ArrayList<Account>();
    	for(AccountWithBalance a: accounts) {
    		returnList.add(a);
    	}
    	return returnList;
	}

	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		this.accountService.remove(this.get(id));
	}
	
	@Override
    @RequestMapping(value="/search", method = RequestMethod.GET)
	public List<Account> search(@RequestParam(value = "label", required = false) String searchLabel) {
		return null;
	}
}
