package SoftwareTest.PracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTest.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css="div[class*='flyInOut']")
	WebElement errorvalidaton;
	
	public String ErrorValidation() {
		return errorvalidaton.getText();
	}
	
	
	public ProductCataloug loginApplication(String emailId, String password) {
		userEmail.sendKeys(emailId);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCataloug productcataloug = new ProductCataloug(driver);
		return productcataloug;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
