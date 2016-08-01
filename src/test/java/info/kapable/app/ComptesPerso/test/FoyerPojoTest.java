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
import org.springframework.context.ApplicationContext;

import info.kapable.app.ComptesPerso.pojo.Foyer;
import info.kapable.app.ComptesPerso.service.FoyerService;

/**
 * @author Mathieu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/services-test-config.xml"})
public class FoyerPojoTest {
	@Autowired
	FoyerService foyerService;

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
		Foyer foyerTest1 = this.foyerService.newFoyer("foyerTest1");
		assertTrue(foyerTest1.getName().equals("foyerTest1"));
		assertTrue(foyerTest1.getId() != null);
		
		/**
		 * Test loading
		 */
		Long id = foyerTest1.getId();
		
		Foyer foyerTest2 = this.foyerService.getFoyer(id);
		assertTrue(foyerTest2.getName().equals("foyerTest1"));
		
		/**
		 * Update must conserve id
		 */
		foyerTest2.setName("FoyerTest2");
		this.foyerService.updateFoyer(foyerTest2);
		
		Foyer foyerTest3 = this.foyerService.getFoyer(id);
		assertTrue(foyerTest3.getName().equals("foyerTest2"));
		assertTrue(foyerTest3.getId() == id);
		
	}
}
