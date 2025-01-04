package SoftwareTest.PracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTest.AbstractComponents.AbstractComponent;

public class ProductCataloug extends AbstractComponent {
	WebDriver driver;

	public ProductCataloug(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='row']")
	List<WebElement> products;

	By productsBy = By.xpath("//div[@class='row']");
	By addToCart = By.xpath("//button[@class='btn w-10 rounded']");

	By toastMessage = By.xpath("//button[@routerlink='/dashboard/cart']");

	public List<WebElement> getProductList() {

		waitForElementToDisappear(productsBy);
		return products;

	}

	public WebElement getPoductByName(String ProductName) {
		WebElement prod = getProductList().stream()
				.filter(s -> s.findElement(By.xpath("//b[text()='Banarsi Saree']")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);
		return prod;

	}

	public void addProductToCart(String ProductName)  throws InterruptedException {

		WebElement prod = getPoductByName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToDisappear2();
	}
}
