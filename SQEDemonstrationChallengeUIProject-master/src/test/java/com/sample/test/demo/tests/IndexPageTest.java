package com.sample.test.demo.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.pages.IndexPage;
import com.sample.test.demo.util.TestUtil;

public class IndexPageTest extends TestBase{

	static Logger logs = Logger.getLogger(IndexPageTest.class);
	IndexPage indexPage;
	TestUtil testUtil;
	String sheetName = "TestData";
	
	public IndexPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	//Fetch data from excel sheet
	@DataProvider(name="getDemoTestData")
	public Object[][] getTestData(){
		Object data[][]= TestUtil.getExcelTestData(sheetName);
		logs.info("Fetched test data from TestData excel file");
		return data;
	}
	
	@BeforeMethod
	private void setUp() throws Throwable {
		logs.info("Launch  the web browser");
		init();
		logs.info("Web browser launched");
		logs.info("Initiate Index page models");
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		logs.info("Initiated Index page models");
	}	
	

//	@Test(priority=0)
//	public void verifyConfirmationDialogMatchesOrderDetails() {
//		
//	}
//	
//	@Test(priority=0)
//	public void verifyCostBasedOnQuantity() {
//		
//	}
//	
//	@Test(priority=0)
//	public void verifyErrorMsgIfNameIsBlank() {
//		
//	}
//	
//	@Test(priority=0)
//	public void verifyErrorMsgIfPhoneIsBlank() {
//		
//	}
//	
//	@Test(priority=0)
//	public void verifyEmailAddressIfEntered() {
//		
//	}
//	
//	@Test(priority=0)
//	public void verifyPhoneNumber() {
//		
//	}
	
	@Test(priority=1, dataProvider="getDemoTestData")
	public void verifyOrderIsSuccessfullyPlaced(String pizzaOption, String toppingOption1, String toppingOption2, String pizzaQuantity, String buyerName, String buyerEmail, String buyerPhone, String paymentType) {		
		logs.info("Fill the complete form and submit the order");
		PizzaTypes pizzaTypes = null;
		switch(pizzaOption) {
		case "SMALL_NOTOPPINGS":
			pizzaTypes = PizzaTypes.SMALL_NOTOPPINGS;
			break;
		case "SMALL_ONETOPPINGS":
			pizzaTypes = PizzaTypes.SMALL_ONETOPPINGS;
			break;
		case "MEDIUM_TWOTOPPINGS":
			pizzaTypes = PizzaTypes.MEDIUM_TWOTOPPINGS;
			break;
		case "LARE_NOTOPPINGS":
			pizzaTypes = PizzaTypes.LARE_NOTOPPINGS;
			break;
		case "LARGE_THREETOPPINGS":
			pizzaTypes = PizzaTypes.LARGE_THREETOPPINGS;
			break;
		}
		PizzaToppings pizzaToppings1 = PizzaToppings.valueOf(toppingOption1);
		PizzaToppings pizzaToppings2 = PizzaToppings.valueOf(toppingOption2);
		logs.info("Pizza 1 - " + pizzaTypes.getDisplayName() + " $" + pizzaTypes.getCost());
		logs.info("Topping 1 - " + pizzaToppings1.getDisplayName());
		logs.info("Topping 2 - " + pizzaToppings2.getDisplayName());
		logs.info("Quantity - " + pizzaQuantity);
		logs.info("Name - " + buyerName);
		logs.info("Email - " + buyerEmail);
		logs.info("Email - " + buyerPhone);
		logs.info("Payment info - " + paymentType);
		indexPage.selectElements(pizzaTypes.getDisplayName() + " $" + pizzaTypes.getCost(), pizzaToppings1.getDisplayName(), pizzaToppings2.getDisplayName(), pizzaQuantity, buyerName, buyerEmail, buyerPhone, paymentType);		
		logs.info("Filled all the fields on page");
		indexPage.submitOrder();
		logs.info("Order submitted");
		String dialogText = indexPage.moveToAlertDialog();
		logs.info("Dialog box popped up with text - " + dialogText);
		Assert.assertEquals("Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings", dialogText);
		logs.info("Dialog box text verified - " + dialogText);
	}
	
	@Test(priority=2)
	public void verifyMandatoryFieldsErrorMessage() {
		logs.info("Order submitted without any entry");
		indexPage.submitOrder();
		String dialogText = indexPage.moveToAlertDialog();
		logs.info("Dialog box popped up with text - " + dialogText);
		//System.out.println(dialogText);
		Assert.assertEquals("Missing name\r\n"
				+ "Missing phone number", dialogText);
		logs.info("Dialog box text verified - " + dialogText);
	}
	
//	@Test(priority=3)
//	public void verifyResetButton() {
//		indexPage.resetPage();
//	}
	
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
            logs.info("------- Webdriver closed -----");
        } catch (Exception e) {
        }
    }
}
