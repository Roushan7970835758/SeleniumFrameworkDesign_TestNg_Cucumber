package Selenium.pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.AbstractComponents;


public class cartPage extends AbstractComponents {
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@class='infoWrap']//h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkOutEle;
	
	public boolean varifyProductDisplay(String item) {
		boolean match =  cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return match;
		
		//No assertion on PO, keep it on tesst page only
	}
	
	public CheckOutPage goToCheckOut() {
		checkOutEle.click();
		
		return new CheckOutPage(driver);
	}
	
	
	
	
	
	
	


}
