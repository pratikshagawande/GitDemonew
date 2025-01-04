package SoftwareTest.PracticeProject.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SoftwareTest.PracticeProject.CartPage;
import SoftwareTest.PracticeProject.ConfirmationPgae;
import SoftwareTest.PracticeProject.LandingPage;
import SoftwareTest.PracticeProject.OrderPage;
import SoftwareTest.PracticeProject.ProductCataloug;
import SoftwareTest.PracticeProject.CheckoutPage;
import SoftwareTest.PracticeProject.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {
	String ProductName = "Banarsi Saree";

	@Test(dataProvider="getData",groups={"purchase"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCataloug productcataloug = landingpage.loginApplication(input.get("emailID"),input.get("password"));

		List<WebElement> products = productcataloug.getProductList();

		productcataloug.addProductToCart(input.get("Product"));
		CartPage cartpage = productcataloug.GotoCartPage();

		Boolean Match = cartpage.VerifyProductDisplay(input.get("Product"));
		Assert.assertTrue(Match);

		LandingPage landingpage = LaunchApplication();

		CheckoutPage checkoutpage = cartpage.GotoCheckout();
		checkoutpage.SelectCountry("india");
		ConfirmationPgae confirmationpage = checkoutpage.SubmitOrder();
		String confirmmessage = confirmationpage.getConfirmationMessage();

		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));

	}

	//@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCataloug productcataloug = landingpage.loginApplication("adviky140222@gmail.com", "Advik@14022022");
		OrderPage orderpage = productcataloug.GotoOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(ProductName));

	}
	@DataProvider
	public Object[][] getData() {
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("emailID", "adviky140222@gmail.com");
		map.put("password", "Advik@14022022");
		map.put("Product", "Banarsi Saree");
		
		HashMap<String, String>map1=new HashMap<String, String>();
		map1.put("emailID", "rahul28@gmail.com");
		map1.put("password", "Rahul28@280888");
		map1.put("Product", "Banarsi Saree");
		
		return new Object[][]{{map},{map1}};
		
		
		
		//return new Object[][] {{"adviky140222@gmail.com","Advik@14022022","ZARA COAT 3"},{"rahul28@gmail.com","Rahul28@280888","ZARA COAT 3"}};
	}
}
