package Selenium.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.TestComponents.BaseTest;
import Selenium.pageObject.CheckOutPage;
import Selenium.pageObject.cartPage;
import Selenium.pageObject.conformationPage;
import Selenium.pageObject.orderPage;
import Selenium.pageObject.productCatalog;

public class submitOrderTest extends BaseTest {
//	String item = "ADIDAS ORIGINAL";
	String country ="India";
	
	@Test(dataProvider="getData",groups = {"perchase","smoke"})
	public void SubmitOrder(HashMap<String,String> map) throws InterruptedException {	
		
		
		productCatalog p1 = l1.logIn(map.get("name"), map.get("password"));
		
		System.out.println(map.get("name")+" " +map.get("password")+" "+map.get("item"));
		
		List<WebElement> element = p1.getProdList();
		WebElement prod = p1.getProdByName(map.get("item"));
		p1.addProdToCart(map.get("item"));
		cartPage c1 = p1.goToCart();

		boolean match = c1.varifyProductDisplay(map.get("item"));
		Assert.assertTrue(match);
		CheckOutPage ck1 = c1.goToCheckOut();
		
		ck1.selectCountry(country);
		conformationPage cm1 = ck1.submitOrder();		
		String cnfMsg = cm1.varifyCnfMsg();				
		Assert.assertTrue(cnfMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	@Test(dataProvider="getData",dependsOnMethods ="SubmitOrder")
//	public void varifyOrderDisplay(String name,String email, String item) throws InterruptedException {
	public void varifyOrderDisplay(HashMap<String,String> map) throws InterruptedException {
//		productCatalog p1 = l1.logIn(name, email);
		productCatalog p1 = l1.logIn(map.get("name"), map.get("password"));
		
		orderPage o1 = p1.goToOrdersPage();
		boolean orderMatch = o1.varifyOrderDisplay(map.get("item"));
		
		Assert.assertTrue(orderMatch);
		
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		HashMap <String,String> map = new HashMap<String,String>();
//		map.put("name","roushan@gmail.com");
//		map.put("password", "Roushan@123");
//		map.put("item", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{....},{"roushankumar22145@gmail.com","Roushan@123","IPHONE 13 PRO"}};
//	}
	
//	@DataProvider
//	public Object[][] getData() throws IOException{
//		System.out.println("first Step of getData()");
//		System.out.println("file path to data: "+System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\Data\\PerchaseData.json");
//		List<HashMap<String,String>> data = getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\Data\\PerchaseData.json");
//		System.out.println("last step of getData()");
//		System.out.println(data);
//		return new Object[][] {{data.get(0)},{data.get(1)}};
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
	    String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\Selenium\\Data\\PerchaseData.json";
	    System.out.println("File path: " + filePath);
	    
	    List<HashMap<String, String>> data = getJsonDataToMap(filePath);
	    if (data == null || data.isEmpty()) {
	        throw new RuntimeException("No data found in the JSON file: " + filePath);
	    }
	    return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	

	
}





























