package info.kapable.app.ComptesPerso.test;

import static org.junit.Assert.*;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatonTest {

	private EmbeddedServer embeddedServer;
	
	private WebDriver driver;
    @Before
    // or @BeforeClass
    public void startServer() throws ServletException {
        embeddedServer = new EmbeddedServer(9191, "/comptesPerso");
        embeddedServer.start();
        driver = new FirefoxDriver();
        driver.get("http://localhost:9191/comptesPerso");
    }
 
    @After
    // or @AfterClass
    public void stopServer() {
        embeddedServer.stop();
        driver.close();
    }
    
	@Test
	public void test() {
		WebElement element;
		element = this.driver.findElement(By.xpath("/html/body"));
		assertTrue(element.getText().contains("Username"));
		this.driver.findElement(By.name("username")).sendKeys("matgou");
		this.driver.findElement(By.name("password")).sendKeys("123456");
		this.driver.findElement(By.name("submit")).click();
		element = this.driver.findElement(By.xpath("/html/body"));
		assertTrue(element.getText().contains("ComptesPerso"));
		
	}

}
