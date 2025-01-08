package Selenium.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.TestComponents.BaseTest;
import Selenium.pageObject.CheckOutPage;
import Selenium.pageObject.cartPage;
import Selenium.pageObject.conformationPage;
import Selenium.pageObject.landingPage;
import Selenium.pageObject.productCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImpli extends BaseTest {
	public landingPage landingPage;
	public productCatalog productCatalog_test;
	public cartPage c1;
	public CheckOutPage ck1;
	public conformationPage cm1;
	
	@Given ("I landed on Ecomerce page")
	public void I_landed_on_Ecomerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given ("^login using the username (.+) and password (.+)$")
	public void login_using_the_username_and_password(String username, String password) {
		 productCatalog_test = landingPage.logIn(username, password);
	}
	
	@When("^I add product (.+) from kart")
	public void I_add_product_from_Kart(String productName) throws InterruptedException {
		List<WebElement> element = productCatalog_test.getProdList();
		WebElement prod = productCatalog_test.getProdByName(productName);
		productCatalog_test.addProdToCart(productName);
	}
	
	@And ("^Checkout product (.+) and submit the order$")
	public void  Checkout_Submit_order(String productName) throws InterruptedException {
		 c1 = productCatalog_test.goToCart();

		boolean match = c1.varifyProductDisplay(productName);
		Assert.assertTrue(match);
		 ck1 = c1.goToCheckOut();
		
		ck1.selectCountry("India");
		 cm1 = ck1.submitOrder();
	}
	
	@Then("{string} Message displayed on ComformationPage")
	public void Message_displayed_ComformationPage() {
		String cnfMsg = cm1.varifyCnfMsg();				
		Assert.assertTrue(cnfMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Then ("{string} message is Displayed")
	public void something_message_is_displayed(String strArg1)throws Throwable {

		Assert.assertEquals(strArg1, l1.getErrMsg());
		driver.close();
	}
}






















