package SoftwareTest.PracticeProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SoftwareTest.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody/tr/td[2]")

	List<WebElement> orderlists;

	public Boolean VerifyOrderDisplay(String ProductName) {

		Boolean matchorder = orderlists.stream().anyMatch(orderlist -> orderlist.getText().equals(ProductName));
		//
		return matchorder;
	}

}
