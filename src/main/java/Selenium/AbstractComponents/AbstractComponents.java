package Selenium.AbstractComponents;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.pageObject.cartPage;
import Selenium.pageObject.orderPage;


public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void waitForEleToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForEleToAppear(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForEleToDisApper(WebElement ele) throws InterruptedException {
		Thread.sleep(4);
		
//		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));       wait for extra 4 sec     method does'nt work application error
//		w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	

}
