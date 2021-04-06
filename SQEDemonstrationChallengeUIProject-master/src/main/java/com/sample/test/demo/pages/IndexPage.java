package com.sample.test.demo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.util.TestUtil;

public class IndexPage extends TestBase{

	//Find all the elements on the page - index.html
	@FindBy(id = "pizza1Pizza")
	WebElement choosePizza;
	
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
	WebElement chooseToppingOne;
	
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
	WebElement chooseToppingTwo;
	
	@FindBy(id = "pizza1Qty")
	WebElement quantity;
	
	@FindBy(id = "pizza1Cost")
	WebElement cost;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(id = "ccpayment")
	WebElement creditCard;
	
	@FindBy(id = "cashpayment")
	WebElement cashOnPickup;	
	
	@FindBy(id = "placeOrder")
	WebElement placeOrderBtn;
	
	@FindBy(id = "reset")
	WebElement resetBtn;
	
	@FindBy(id = "dialog")
	WebElement dialog;
	
	@FindBy(xpath = "//div[@id='dialog']/p")
	WebElement dialogText;
	
	TestUtil testUtil = new TestUtil();
	
	//Initializing the page objects
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public String selectPizza(WebElement webElement, String pizzaOption) {		
		return testUtil.selectDropDown(webElement, pizzaOption);
	}
	
	public String selectToppings1(WebElement webElement, String toppingOption1) {		
		return testUtil.selectDropDown(webElement, toppingOption1);		
	}
	
	public String selectToppings2(WebElement webElement, String toppingOption2) {		
		return testUtil.selectDropDown(webElement, toppingOption2);
	}
	
	//Fill the values on page based on test data
	public void selectElements(String pizzaOption, String toppingOption1, String toppingOption2, String pizzaQuantity, String buyerName, String buyerEmail, String buyerPhone, String paymentType) {
		selectPizza(choosePizza, pizzaOption);
		selectToppings1(chooseToppingOne, toppingOption1);
		selectToppings2(chooseToppingTwo, toppingOption2);
		quantity.clear();
		quantity.sendKeys(pizzaQuantity);
		name.sendKeys(buyerName);
		email.sendKeys(buyerEmail);
		phone.sendKeys(buyerPhone);
		selectRadioButton(paymentType);
	}
	
	//Select radio button based on input
	private void selectRadioButton(String paymentType) {
		if(!paymentType.isEmpty() || paymentType != null) {
			if(paymentType.equalsIgnoreCase("Credit Card")) {
				creditCard.click();
			} else {
				cashOnPickup.click();
			}
		}		
	}
	
	//Submit order
	public void submitOrder() {		
		placeOrderBtn.click();				
	}
	
	//Reset page
	public void resetPage() {
		//selectElements(pizzaOption, toppingOption1, toppingOption2, pizzaQuantity, buyerName, buyerEmail, buyerPhone, null);
				
	}
	
	//Get the text of dialog
	public String moveToAlertDialog() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dialogText.getText().toString();	
	}	
	
}
