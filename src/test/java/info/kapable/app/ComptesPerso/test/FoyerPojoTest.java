/**
 * 
 */
package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationContext;

import info.kapable.app.ComptesPerso.pojo.Home;
import info.kapable.app.ComptesPerso.service.HomeService;

/**
 * @author Mathieu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-test-config.xml"})
@Transactional
public class FoyerPojoTest {
	@Autowired
	HomeService foyerService;

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
}
