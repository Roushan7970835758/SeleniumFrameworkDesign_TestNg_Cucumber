package Selenium.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;

public class landingPage extends AbstractComponents  {
	public WebDriver driver;
	public landingPage(WebDriver driver){
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Pagefactor
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	
	@FindBy(id="login")
	WebElement submitBtn; 
	
	@FindBy(className="ng-trigger-flyInOut")
	WebElement ErrMsg;
	
	
	public productCatalog logIn(String email,String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		
		this.submitBtn.click();
		
		return  new productCatalog(driver);
	
	}
	public String getErrMsg() {
		waitForEleToAppear(ErrMsg);
		return ErrMsg.getText();
	}
	public  void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
