package info.kapable.app.ComptesPerso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController extends CrudController<Account> {
	@Autowired
	AccountService accountService;
    @RequestMapping(method = RequestMethod.GET)
    public String list(ModelMap model) {
    	List<Account> accounts = this.accountService.getAccountForUser("matgou");
    	model.addAttribute("list", accounts);
    	return "accountList";
    }
}
