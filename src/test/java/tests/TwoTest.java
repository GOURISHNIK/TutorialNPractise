package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	public WebDriver driver;
	
	@Test
	public void twoTest() throws InterruptedException, IOException {
		System.out.println("this is twoTest");
				
	}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
