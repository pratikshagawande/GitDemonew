package SoftwareTest.PracticeProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SoftwareTest.AbstractComponents.AbstractComponent;

public class ConfirmationPgae extends AbstractComponent {
WebDriver driver;
	public ConfirmationPgae(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="hero-primary")
	WebElement confirmmessage;
	
	public String getConfirmationMessage() {
		return	confirmmessage.getText();
		

		
	}

}
