package Selenium.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;

public class orderPage extends AbstractComponents {
	public WebDriver driver;
	public orderPage(WebDriver driver){
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	



	@FindBy(xpath="//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> orderProducts;
	
	public boolean varifyOrderDisplay(String item) {
		boolean match =  orderProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return match;
		
		//No assertion on PO, keep it on tesst page only
	}

}
