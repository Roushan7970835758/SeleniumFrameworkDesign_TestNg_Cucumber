package Selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;


public class conformationPage extends AbstractComponents {
	WebDriver driver;
	
	public conformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="hero-primary")
	WebElement cnfMsg;
	
	public String varifyCnfMsg() {
		String comfmMsg = cnfMsg.getText();
		System.out.println("conform msg is : "+comfmMsg);
		return comfmMsg;
	}
	

}
