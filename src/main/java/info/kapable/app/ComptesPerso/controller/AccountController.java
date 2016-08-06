package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.service.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountController extends CrudController<Account> {
	@Autowired
	AccountService accountService;
    @RequestMapping(value="/accounts", method = RequestMethod.GET)
    public List<Account> list() {
    	List<Account> accounts = this.accountService.getAccountForUser("matgou");
    	return accounts;
    }
    
	@Override
    @RequestMapping("/{id}")
	public Account get(@PathVariable("id") String id) {
		return this.accountService.get(Long.valueOf(id));
	}
}
