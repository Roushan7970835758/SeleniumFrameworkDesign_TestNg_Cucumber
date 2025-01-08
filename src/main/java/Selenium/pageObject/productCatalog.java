package Selenium.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Selenium.AbstractComponents.AbstractComponents;


public class productCatalog extends AbstractComponents {
	WebDriver driver;
	public productCatalog(WebDriver driver){
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Pagefactor
	
	
	@FindBy(css=".mb-3")
	List<WebElement> element;
	
	@FindBy(className="ng-trigger-fadeIn")
	WebElement spinner;
	
	@FindBy(xpath = "//button[contains(text(),'Cart ')]")
	WebElement kart;
	
	@FindBy(xpath ="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	
	
//	@FindBy(xpath="//button[contains(text(),\\\" Add To Cart\\\")]")
//	WebElement addToCart;   //does'nt work ... have to find in stream return
	//*****NOTE****    We Can't apply pageFactory within webelement.find element      pageFactory only for driver.element
	
//	By addToCart = By.xpath("//button[contains(text(),\" Add To Cart\")]");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By productBy = By.className("mb-3");
	By ToastMsg = By.id("toast-container");
	
	
	
	
	public List<WebElement> getProdList() {
		waitForEleToAppear(productBy);
		return element;
	}
	
	public WebElement getProdByName(String item) {
		WebElement prod = getProdList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(item)).findFirst().orElse(null);
		System.out.println("get product by name" + prod.getText());
		return prod;
	}
	
	public void addProdToCart(String item) throws InterruptedException {
		
		getProdByName(item).findElement(addToCart).click();
		waitForEleToAppear(ToastMsg);
//		System.out.println(ToastMsg.toString());
		waitForEleToDisApper(spinner);
		
	}

	public cartPage goToCart() throws InterruptedException {
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[contains(text(),'Cart ')]")).click();
		kart.click();
		
		return new cartPage(driver);
	}
	
	public orderPage goToOrdersPage() throws InterruptedException {
		Thread.sleep(2000);
		orderHeader.click();
		return new orderPage(driver);
		
	}
	
	
	
	
}













