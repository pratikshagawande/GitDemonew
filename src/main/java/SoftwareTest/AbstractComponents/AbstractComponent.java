package SoftwareTest.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SoftwareTest.PracticeProject.CartPage;
import SoftwareTest.PracticeProject.OrderPage;


public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartclick;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderclick;

	public void waitForElementToDisappear(By finBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(finBy));
	}

	public void waitForElementToDisappear2() throws InterruptedException {

		Thread.sleep(2000);
	}

	public void waitForElementToAppear(By finBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(finBy));

	}

	public CartPage GotoCartPage() {
		cartclick.click();
		
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage GotoOrderPage() {
		orderclick.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
}