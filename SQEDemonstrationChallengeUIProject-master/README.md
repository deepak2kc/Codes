## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 1. Pizza_Order_successful_flow_Validation_01: Validate the successful pizza ordering flow with all possible combinations including all pizza types , 	topping1 types and topping 2 types.

	Expected Result: The flow should complete successfully for all possible flows
	(The above can be broken in sub test cases)

 2. Pizza_Order_Mandatory_Field_Validation_02 : Validate the order can not be submitted with null mandatory fields.

	Expected Result: An error should come if the user tries to submit the order without populating mandatory fields like name and phone.

 3. Pizza_Order_Field_Validation_03 : Validate all UI fields on the page .

	Expected Result: Text boxes should allow text, email field should accept email format, phone should accept alphanumeric . The field lengths should be as per specified requirement.

 4. Pizza_Order_cost_Quantity_Validation_04 : Validate the cost of the order updates as per the quantity of the pizzas selected.  Validate the cost   is not affected by type of toppings.

	Expected Result: The cost of the order should be in sync with the quantity of the pizzas selected.  The cost should not change with the topping types.

 5. Pizza_Order_Quantity_Validation_05 : Validate the success message on order placement reflects the details of the pizza ordered as well as the  	 overall cost.

	Expected Result: The success message should show ordered pizza details

 6. Pizza_Order_successful_flow_Validation_06: Validate the successful pizza ordering with all possible combinations including all pizza types, 	 topping1 types and topping 2 types.

	Expected Result: The flow should complete successfully for all possible flows

 7. Pizza_Order_no_topping_flow_Validation_07: Validate the topping 1 and topping 2 options when pizza type is selected as no topping

	Expected Result: topping 1 and topping 2 types are disabled when pizza type is selected as no topping

 8. Pizza_Order_CC_payment_flow_Validation_08: Validate the credit card payment information flow.

	Expected Result: Once user selects the payment type as credit card, Fields should be presented to capture credit card information and should be encrypted and secured . It should not be saved anywhere in the db or cache.

 9. Pizza_Order_COP_payment_flow_Validation_09: Validate the cash on pickup payment information flow.

	Expected Result: Once user selects the payment type as cash on pickup, user should be able to submit the order and no fields should be presented to the user. User should see the pop up modal with order and payment details.

 10. Pizza_Order_BVA_Quantity_Validation_10: Validate the quantities of the pizza for the min and max allowed limits. Use data points such as -1, 	  99999 and intermediate values like 30 or so on for price validation.

	Expected Result: Quantity of the pizzas should be always greater than 0 for successful order placement. the system should not break for 1 (min) and 99999(max) counts. Also, the intermediate quantities should work as expected. 
 
 
#### Defects / Issues
 1. "$" sign is not coming before total price on dialog box after placing the order.
 2. When selecting pizza with no toppings option then both the toppings drop downs should be disabled.
 3. When selecting pizza with one topings option then only one Toppings drop down should be available.
 4. User should not be able to click on "Place Order" button if there is no selection from Pizza drop down.
 5. Pizza and quantity should be mandatory fields and should be marked with asterisk.
 6. After placing the order, topping drop down fields are not resetting to "Choose a topping".
 7. User is able to place the order without selecting the payment information.
 8. Reset button is not working properly. After clicking on Reset button, topping drop down fields are not resetting to "Choose a topping".
 9. User should not be able to "Place Order" if Quantity field is zero "0".

