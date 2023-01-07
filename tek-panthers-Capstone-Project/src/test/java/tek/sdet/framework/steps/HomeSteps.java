package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	// all your step definition classes will extends CommonUtility class
	// we need to create object of POMFactory class
	// PomFactory instance should be on top of the class
	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle(); // wrote this one in CommonUtility
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info(actualTitle + "is equal to " + expectedTitle);
	}

	@Then("User verify retail page logo is present")
	public void userVerifyRetailPageLogoIsPresent() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().logo));
		logger.info("logo is present");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allDepartments);
		logger.info("user click on all deparments");

	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {

		List<List<String>> shopByDepartment = dataTable.asLists(String.class);

		for (int i = 0; i < shopByDepartment.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(
					getDriver().findElement(By.xpath("//span[text()='" + shopByDepartment.get(0).get(i) + "']"))));
			logger.info(shopByDepartment.get(0).get(i) + "is present");
		}
	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> dept = factory.homePage().sideBar;
		for (WebElement element : dept) {
			if (element.getText().equals(department)) {
				element.click();
				break;

			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> dept = factory.homePage().sideBar;
		for (int i = 0; i < departmentOptions.get(0).size(); i++) {

			for (WebElement element : dept) {
				if (element.getText().equals(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(element.isDisplayed());
					logger.info(element.getText() + " is presnt");
				}
			}
		}
	}

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String value) {
		sendText(factory.homePage().allDepartments, value);
		logger.info(value + " was selected from the drop down");
		slowDown();
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.homePage().itemkassaoutdoor);
		logger.info("user clicked on item");
	}

	@When("User select quantity '2'")
	public void userSelectQuantity() {
		click(factory.homePage().quantityselection);
		logger.info("user selected quantity");

	}

	@When("User click add to Cart button")
	public void userclickAddToCartButton() {
		click(factory.homePage().addToCartButton);
		logger.info("user clicked add to cart button");

	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.homePage().search);

		logger.info("user click on search button");
		slowDown();
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String value) {
		sendText(factory.homePage().searchInput, value);
		logger.info("User should click on the item");
		slowDown();
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String expectedQuantity) {
		Assert.assertEquals(expectedQuantity, factory.homePage().quantityselection5.getText());
		logger.info("the cart icon quantity changed to " + expectedQuantity);
	}

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		waitTillPresence(factory.homePage().addToCartButton);
		click(factory.homePage().addToCartButton);
		logger.info("user click on cart button");
		slowDown();
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		waitTillPresence(factory.homePage().proceedBtn);
		click(factory.homePage().proceedBtn);
		logger.info("user click on proceed button");
		slowDown();
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homePage().addaddressBtn);
		logger.info("user click on proceed button");
		slowDown();

	}

	@Then("User fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addaddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.homePage().country, addaddress.get(0).get("country"));
		//clearTextUsingSendKeys(factory.homePage().fullNameInput);
		click(factory.homePage().country);
		sendText(factory.homePage().fullName, addaddress.get(0).get("fullName"));
		//clearTextUsingSendKeys(factory.homePage().phoneNumberInput);
		sendText(factory.homePage().phoneNumberInput, addaddress.get(0).get("phoneNumber"));
		//clearTextUsingSendKeys(factory.homePage().streetInput);
		sendText(factory.homePage().streetInput, addaddress.get(0).get("streetAddress"));
		//clearTextUsingSendKeys(factory.homePage().apartmentInput);
		sendText(factory.homePage().apartmentInput, addaddress.get(0).get("apt"));
		//clearTextUsingSendKeys(factory.homePage().cityInput);
		sendText(factory.homePage().cityInput, addaddress.get(0).get("city"));
		//clearTextUsingSendKeys(factory.homePage().streetInput);
		selectByVisibleText(factory.homePage().state, addaddress.get(0).get("state"));
		//clearTextUsingSendKeys(factory.homePage().zipCodeInput);
		click(factory.homePage().state);
		sendText(factory.homePage().zipCodeInput, addaddress.get(0).get("zipCode"));
		logger.info("user address is now added");
		slowDown();
	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.homePage().addpyBtn);
		logger.info("user click Add a credit card or Debit Card for Payment method");
		slowDown();
	}

	@And("User fill Debit or credit card information")
	public void UserFillDebitOrCreditCardInformation(DataTable cardinfo) {
		List<Map<String, String>> addpayment = cardinfo.asMaps(String.class, String.class);
		sendText(factory.homePage().cardNumberInput, addpayment.get(0).get("cardNumber"));
		sendText(factory.homePage().nameOnCardInput, addpayment.get(0).get("nameOnCard"));
		sendText(factory.homePage().expirationMonthInput, addpayment.get(0).get("expirationMonth"));
		sendText(factory.homePage().expirationYearInput, addpayment.get(0).get("expirationYear"));
		sendText(factory.homePage().securityCodeInput, addpayment.get(0).get("securityCode"));
		logger.info("user card is now added");
	}

	@Then("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.homePage().pysubmitBtn);
		logger.info("user click on Add your card  button");
		slowDown();
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homePage().placeOrderBtn);
		logger.info("user click on place order button");
		slowDown();
	}

	@Then("a message should be displayed ‘Order Placed, Thanks’")
	public void aMessageShouldBeDisplayedOrderPlacedThanks() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().orderPlacedSuccessfully));

	}
	
	@Given("User select quantity '5'")
	public void userSelectQuantity5() {
		waitTillPresence(factory.homePage().quantityselection5);
		click(factory.homePage().quantityselection5);
		slowDown();
		waitTillPresence(factory.homePage().cartBtn);
		click(factory.homePage().cartBtn);
		logger.info("user selected quantity");
		
		
		
		
	}

}
