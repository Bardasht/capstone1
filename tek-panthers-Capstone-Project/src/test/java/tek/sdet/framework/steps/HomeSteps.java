package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		click(factory.homePage().idAddtoTheCartBtn);
		logger.info("user clicked add to cart button");
		slowDown();
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
		slowDown();
		//click(factory.homePage().addToCartButton);
		logger.info("the cart icon quantity changed to " + expectedQuantity);
		slowDown();
	}
	

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		waitTillPresence(factory.homePage().cartBtn);
		click(factory.homePage().cartBtn);
		logger.info("user click on cart button");
		
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
		waitTillPresence(factory.homePage().addAddressBtn1);
		click(factory.homePage().addAddressBtn1);
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
		waitTillPresence(factory.homePage().idAddtoTheCartBtn);
		click(factory.homePage().idAddtoTheCartBtn);
		logger.info("user selected quantity");
		
	}
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.homePage().orderLink);
		logger.info("user clicked on order");
		
	}
		
		
//	}
//	@When("User click on first order in list")
//	public void userClickOnFirstOrderInList() {
//		click(factory.homePage().orderselect);
//		logger.info("user selected the  order");
//		
//		
//	}
	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.homePage().cancelBTN);
		logger.info("user clicked on cancel order");
		slowDown();
		
		
	}
	@When("User select the cancelation Reason ‘Bought wrong item’")
	public void userSelectTheCancelationReasonBoughtWrongItem() {
		click(factory.homePage().wrongitem);
		logger.info("user clicked on reason option");
		
	}
	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.homePage().ordercancel);
		logger.info("user clicked on cancel Button");
		
		
	}
	@Then("a cancelation message should be displayed ‘Your Order Has Been Cancelled’")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().YourOrderHasBeenCancelled));
		
		
	}
	
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		
		click(factory.homePage().returnBTN1);
		logger.info("user clicked on return Button");
		
	}
	@When("User select the Return Reason ‘Item damaged’")
	public void userSelectTheReturnReasonItemDamaged() {
		click(factory.homePage().wrongitem);
		logger.info("user select on wrong item");
		
	}
	
	@When("User select the drop off service ‘FedEx’")
	public void userSelectTheDropOffServiceFedEx() {
		click(factory.homePage().fedex);
		logger.info("user select on dropoff");
		
		
	}
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.homePage().returnBTN);
		logger.info("user clicked on return item");
		
		
	}
	@Then("a cancelation message should be displayed ‘Return was successful’")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().yourorderhasbeenreturned));
		
		
		
	}
	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.homePage().reviewitem);
		logger.info("user clicked on review item");
		
		
	}
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineHeadlineValueAndReviewText(String headline,String review) {
		sendText(factory.homePage().headlineinput, headline);
		sendText(factory.homePage().descriptioninput,review );
		logger.info("user submited the review");
		
		
	}
	
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.homePage().reviewsubmitbtn);
		logger.info("user clicked on review submit button");
		slowDown();
		
	}
	
	@Then("a review message should be displayed ‘Your review was added successfully’")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().Yourreviewwasaddedsuccessfully));
		logger.info("user review was submited");
	}
}
		
	

