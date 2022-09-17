package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogin {
WebDriver driver;
	public AccountLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordFields;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	public WebElement emailField() {
		return emailField;
	}

	public WebElement passwordFields() {
		return passwordFields;
	}

	public WebElement loginButton() {
		return loginButton;
	}

}
