package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import info.kapable.app.ComptesPerso.controller.AccountController;
import info.kapable.app.ComptesPerso.controller.StatusController;
import info.kapable.app.ComptesPerso.pojo.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-config.xml"})
@Transactional
public class AccountControllerTest {
	@Autowired
	private AccountController controller;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test() {
		Account a = new Account();
		a.setLabel("Compte test");
		a.setIntialValue(10.);
		a.setType(Account.TYPE_COMPTE_COURANT);
		this.controller.save(a);
		
		List<Account> l = this.controller.list();
		assertTrue(l.size() > 0);
	}

}
