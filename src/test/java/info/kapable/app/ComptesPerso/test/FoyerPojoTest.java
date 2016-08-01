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
		Foyer foyerTest1 = this.foyerService.newFoyer("foyerTest1");
		assertTrue(foyerTest1.getName().equals("foyerTest1"));
	}
}
