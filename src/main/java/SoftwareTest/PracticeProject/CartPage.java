package SoftwareTest.PracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SoftwareTest.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> productTitles;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutclick;

	public Boolean VerifyProductDisplay(String ProductName) {

		Boolean Match = productTitles.stream().anyMatch(s -> s.getText().equalsIgnoreCase(ProductName));
		return Match;

	}

	public CheckoutPage GotoCheckout() {
		checkoutclick.click();
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}
}