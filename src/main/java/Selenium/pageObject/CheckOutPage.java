package Selenium.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;


public class CheckOutPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement submit;
	
	By result = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForEleToAppear(result);
		System.out.println("The result has been appeared");
		selectCountry.click();
	}
	
	public conformationPage submitOrder() {
		submit.click();
		
		return new conformationPage(driver);
	}
	
	
	
	
	
	
	
	

}
