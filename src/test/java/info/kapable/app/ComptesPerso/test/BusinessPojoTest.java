/**
 * 
 */
package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationContext;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Home;
import info.kapable.app.ComptesPerso.pojo.Transaction;
import info.kapable.app.ComptesPerso.service.AccountService;
import info.kapable.app.ComptesPerso.service.HomeService;
import info.kapable.app.ComptesPerso.service.TransactionService;

/**
 * @author Mathieu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-test-config.xml"})
@Transactional
public class BusinessPojoTest {
	@Autowired
	HomeService foyerService;
	@Autowired
	AccountService accountService;
	@Autowired
	TransactionService transactionService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createFoyerTest() {
		/**
		 * Test creation
		 */
		Home foyerTest1 = this.foyerService.newFoyer("foyerTest1");
		assertTrue(foyerTest1.getName().equals("foyerTest1"));
		assertTrue(foyerTest1.getId() != null);
		
		/**
		 * Test loading
		 */
		Long id = foyerTest1.getId();
		
		Home foyerTest2 = this.foyerService.getFoyer(id);
		assertTrue(foyerTest2.getName().equals("foyerTest1"));
		
		/**
		 * Update must conserve id
		 */
		foyerTest2.setName("FoyerTest2");
		this.foyerService.updateFoyer(foyerTest2);
		
		Home foyerTest3 = this.foyerService.getFoyer(id);
		System.out.println(foyerTest3.getName());
		assertTrue(foyerTest3.getName().equals("FoyerTest2"));
		assertTrue(foyerTest3.getId() == id);
	}


	@Test
	public void accountAndOperationTest() {
		Account a = new Account();
		a.setIntialValue(.0);
		a.setLabel("Compte de test unitaire");
		a.setType(Account.TYPE_COMPTE_COURANT);
		a.setEnable(true);
		
		this.accountService.save(a);
		assertTrue(a.getId() != null);
		Long aId = a.getId();
		
		Transaction t = new Transaction();
		t.setAccount(a);
		t.setCredit(10.);
		t.setDate(new Date());
		t.setDescription("Ajout de 10 euros pour test unitaire");
		t.setPointedTransaction(false);
		this.transactionService.save(t);
		assertTrue(t.getId() != null);
		Long tId = t.getId();
		
		// Verification du calcul de la balance
		assertTrue(this.accountService.getRealBalance(a) == 10.);
		assertTrue(this.accountService.getPointedBalance(a) == 0.);
		
		t.setPointedTransaction(true);
		this.transactionService.updateTransaction(t);
		assertTrue(this.accountService.getPointedBalance(a) == 10.);
		
	}
}
