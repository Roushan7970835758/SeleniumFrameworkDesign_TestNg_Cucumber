package Selenium.test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.TestComponents.BaseTest;
import Selenium.pageObject.CheckOutPage;
import Selenium.pageObject.cartPage;
import Selenium.pageObject.conformationPage;
import Selenium.pageObject.productCatalog;



public class AppTest extends  BaseTest{
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {

		// TODO Auto-generated method stub
		
		String item = "ADIDAS ORIGINAL";
		String country ="India";
		
		
		productCatalog p1 = l1.logIn("roushan@gmail.com", "Roushan@123");
		List<WebElement> element = p1.getProdList();
		WebElement prod = p1.getProdByName(item);
		p1.addProdToCart(item);
		cartPage c1 = p1.goToCart();
	
		boolean match = c1.varifyProductDisplay(item);
		Assert.assertTrue(match);
		CheckOutPage ck1 = c1.goToCheckOut();
		
		ck1.selectCountry(country);
		conformationPage cm1 = ck1.submitOrder();		
		String cnfMsg = cm1.varifyCnfMsg();				
		Assert.assertTrue(cnfMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		System.out.println("Process completed Succesfully... !");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
