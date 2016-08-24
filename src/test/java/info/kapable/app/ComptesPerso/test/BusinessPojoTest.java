/**
 * 
 */
package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.kapable.app.ComptesPerso.pojo.Account;
import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.Home;
import info.kapable.app.ComptesPerso.pojo.Operation;
import info.kapable.app.ComptesPerso.service.AccountService;
import info.kapable.app.ComptesPerso.service.CategoryService;
import info.kapable.app.ComptesPerso.service.HomeService;
import info.kapable.app.ComptesPerso.service.OperationService;

/**
 * @author Mathieu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-config.xml"})
@Transactional
public class BusinessPojoTest {
	@Autowired
	HomeService foyerService;
	@Autowired
	AccountService accountService;
	@Autowired
	OperationService operationService;
	@Autowired
	CategoryService categoryService;

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
		Operation t = new Operation();
		t.setAccount(a);
		t.setCredit(10.);
		t.setDate(new Date());
		t.setDescription("Ajout de 10 euros pour test unitaire");
		t.setPointedTransaction(false);
		this.operationService.save(t);
		assertTrue(t.getId() != null);
		// Verification du calcul de la balance
		assertTrue(this.accountService.getRealBalance(a) == 10.);
		assertTrue(this.accountService.getPointedBalance(a) == 0.);
		
		t.setPointedTransaction(true);
		this.operationService.save(t);
		assertTrue(this.accountService.getPointedBalance(a) == 10.);
		
	}

	@Test
	public void categoryTest() {
		Category c = new Category("Parent category 1");
		
		this.categoryService.save(c);
		assertTrue(c.getId() != null);
		
		Category c2 = new Category("Child category 2");
		c2.setParent(c);
		this.categoryService.save(c2);
		assertTrue(c2.getId() != null);
		
		Category c3 = new Category("Child category 3");
		c3.setParent(c);
		this.categoryService.save(c3);
		assertTrue(c3.getId() != null);
	}
}
