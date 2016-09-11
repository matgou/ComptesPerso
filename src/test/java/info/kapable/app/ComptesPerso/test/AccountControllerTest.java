package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.controller.AccountController;
import info.kapable.app.ComptesPerso.controller.CategoryController;
import info.kapable.app.ComptesPerso.controller.OperationController;
import info.kapable.app.ComptesPerso.controller.ThirdPartyController;
import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.AccountWithBalance;
import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.Operation;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-config.xml"})
@Transactional
public class AccountControllerTest {
	@Autowired
	private AccountController controller;
	
	@Autowired
	private OperationController operationController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private ThirdPartyController thirdPartyController;

	private Account a;

	private Account a2;
	
	@Before
	public void setUp() throws Exception {
		a = new Account();
		a.setLabel("Compte test");
		a.setIntialValue(10.);
		a.setType(Account.TYPE_COMPTE_COURANT);
		this.controller.save(a);
		

		a2 = new Account();
		a2.setLabel("Compte test sans op�ration");
		a2.setIntialValue(10.);
		a2.setType(Account.TYPE_COMPTE_COURANT);
		this.controller.save(a2);
		

		Category c = new Category();
		c.setLabel("test");
		categoryController.save(c);
		
		ThirdParty tp = new ThirdParty();
		tp.setLabel("test");
		this.thirdPartyController.save(tp);

		Operation t = new Operation();
		t.setAccount(a);
		t.setDate(new Date());
		t.setDebit(10.);
		t.setDescription("Une op�ration");
		t.setCategory(c);
		t.setThirdParty(tp);
		this.operationController.save(t);
	}
	
	@Test
	public void test() {
		List<AccountWithBalance> l = this.controller.listAll().getContent();
		assertTrue(l.size() > 0);
		AccountWithBalance awb = null;
		for(AccountWithBalance a_temp: l) {
			if(a2.getId() == a_temp.getId()) {
				awb = a_temp;
			}
		}
		assertTrue(awb.getRealBalance() == 10.);
		assertTrue(awb.getPointedBalance() == 10.);
		
		List<AccountWithBalance> l2 = this.controller.listAll().getContent();
		assertTrue(l2.size() > 0);

		AccountWithBalance awb2 = null;
		for(AccountWithBalance a_temp: l) {
			if(a.getId() == a_temp.getId()) {
				awb2 = a_temp;
			}
		}
		Double rb = awb2.getRealBalance();
		Double pb = awb2.getPointedBalance();
		assertTrue(rb == 0.);
		assertTrue(pb == 10.);
		
		
	}

}
