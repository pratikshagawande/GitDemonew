package SoftwareTest.PracticeProject.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SoftwareTest.PracticeProject.CartPage;
import SoftwareTest.PracticeProject.LandingPage;
import SoftwareTest.PracticeProject.ProductCataloug;
import SoftwareTest.PracticeProject.TestComponents.BaseTest;
import SoftwareTest.PracticeProject.TestComponents.Retry;

public class LoginErrorValidation extends BaseTest {

	@Test(retryAnalyzer =Retry.class)
	public void submitOrder() {
		String ProductName = "Banarsi Saree";
ProductCataloug productcataloug = landingpage.loginApplication("adviky1402223@gmail.com", "Advik@140220223");
landingpage.ErrorValidation();
Assert.assertEquals(landingpage.ErrorValidation(), "Incorrect email or password.");


	}
	
	@Test(groups= {"errorvalidation"})
	public void ProductErrorValidation() throws InterruptedException {
	String ProductName = "Banarsi Saree";
	ProductCataloug productcataloug = landingpage.loginApplication("rahul28@gmail.com", "Rahul28@280888");

	List<WebElement> products = productcataloug.getProductList();

	productcataloug.addProductToCart(ProductName);
	CartPage cartpage = productcataloug.GotoCartPage();

	Boolean Match = cartpage.VerifyProductDisplay("Banarsi Saree");
	Assert.assertFalse(Match);
}
}