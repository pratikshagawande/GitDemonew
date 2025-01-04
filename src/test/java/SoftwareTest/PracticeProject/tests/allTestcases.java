package SoftwareTest.PracticeProject.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class allTestcases {

	@Test
	public void SubMitOrder() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		String ProductName = "BANARSI SAREE";
		driver.findElement(By.id("userEmail")).sendKeys("adviky140222@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Advik@14022022");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4.col-md-6.col-sm-10"));
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Banarsi Saree']")));
		WebElement product = products.stream().filter(
				s -> s.findElement(By.xpath("//b[text()='Banarsi Saree']")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);

		product.findElement(By.cssSelector(".btn.w-10.rounded")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection'] /h3"));
		Boolean match = cartProducts.stream().anyMatch(
				s -> s.findElement(By.xpath("//div[@class='cartSection']/h3")).getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		WebElement countryName = driver
				.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]"));
		Actions a = new Actions(driver);
		a.moveToElement(countryName).click().build().perform();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		String actualResult = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(actualResult.equalsIgnoreCase("Thankyou for the order."));

	}

}
