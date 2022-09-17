package tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountLogin;
import pageobjects.LandingPage;
import pageobjects.MyAccount;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	String actualStatus;
	Logger logger;

	@Test(dataProvider = "getData")
	public void loginTest(String email1, String password1, String expectedStatus) throws InterruptedException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountButton().click();
		landingPage.loginOption().click();

		AccountLogin accountLogin = new AccountLogin(driver);
		accountLogin.emailField().sendKeys(email1);
		accountLogin.passwordFields().sendKeys(password1);
		accountLogin.loginButton().click();

		MyAccount myAccount = new MyAccount(driver);
		try {
			if (myAccount.editOptionAvailable().isDisplayed())
				actualStatus = "successfull";
		} catch (Exception e) {
			actualStatus = "invalidLogin";
		}
		
		Assert.assertEquals(actualStatus, expectedStatus);
		Thread.sleep(1000);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "arun.selenium11@gmail.com", "Second@123", "successfull" } };
		// ,{ "arun.selenium@gmail.com", "incorrect", "invalidLogin" } };
		return data;
	}

	@BeforeMethod
	public void setup() throws IOException {
		logger = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		logger.debug("browser launced");
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
