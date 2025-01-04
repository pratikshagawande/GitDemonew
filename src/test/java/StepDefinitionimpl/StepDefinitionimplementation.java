package StepDefinitionimpl;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SoftwareTest.PracticeProject.CartPage;
import SoftwareTest.PracticeProject.CheckoutPage;
import SoftwareTest.PracticeProject.ConfirmationPgae;
import SoftwareTest.PracticeProject.LandingPage;
import SoftwareTest.PracticeProject.ProductCataloug;
import SoftwareTest.PracticeProject.TestComponents.BaseTest;
import SoftwareTest.PracticeProject.tests.StandAloneTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimplementation extends BaseTest {
	public LandingPage landingpage;
	public ProductCataloug productcataloug;
	public CheckoutPage checkoutpage;
	public ConfirmationPgae confirmationpage;

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
		landingpage = LaunchApplication();

	}

	@Given("^Logged in with (.+)and (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {

		productcataloug = landingpage.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_product_name_to_cart(String ProductName) throws InterruptedException {
		List<WebElement> products = productcataloug.getProductList();

		productcataloug.addProductToCart(ProductName);

	}

	@When("^checkout(.+) and submit the order$")
	public void checkout_product_name_and_submit_the_order(String ProductName) throws IOException {
		CartPage cartpage = productcataloug.GotoCartPage();

		Boolean Match = cartpage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(Match);

		LandingPage landingpage = LaunchApplication();

		checkoutpage = cartpage.GotoCheckout();
		checkoutpage.SelectCountry("india");
		confirmationpage = checkoutpage.SubmitOrder();

	}

	@Then("{String} message is displayed on the ConfirmationPage.")
	public void thankyou_for_the_order_message_is_displayed_on_the_confirmation_page(String string) {
		String confirmmessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
	}

}
