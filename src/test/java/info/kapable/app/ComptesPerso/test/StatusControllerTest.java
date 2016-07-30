/**
 * 
 */
package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import info.kapable.app.ComptesPerso.controller.StatusController;

/**
 * @author Johanna
 *
 */
public class StatusControllerTest {

	public ModelMap model;
	public StatusController controller;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.controller = new StatusController();
		this.model = new ModelMap();
	}

	@Test
	public void sayStatusTest() {
		String ret = this.controller.sayStatus(this.model);
		assertTrue(ret.contains("monitoring"));
	}
}
