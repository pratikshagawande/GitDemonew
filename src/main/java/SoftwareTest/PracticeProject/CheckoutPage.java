package SoftwareTest.PracticeProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import SoftwareTest.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = " //input[@placeholder='Select Country']")
	WebElement CountryList;

	By countynamelistloaded = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement seectCountry;

	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeorder;

	@FindBy(className = "hero-primary")
	WebElement ConfimationMessge;

	public void SelectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(CountryList, "India").build().perform();
		//waitForElementToAppear(countynamelistloaded);
		seectCountry.click();

	}

	public ConfirmationPgae SubmitOrder() {
		placeorder.click();
		ConfirmationPgae confirmationpage=new ConfirmationPgae(driver);
		return confirmationpage;
		
	}

}
