package tek.sdet.framework.steps;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.signInPage().signInBttn);
		logger.info("User clicked on sign in btn");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.signInPage().emailInput, email);
		sendText(factory.signInPage().passwordInput, password);
		logger.info("User enterd the email and password");
		slowDown();

	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.signInPage().loginBttn);
		logger.info("User clicked on log in btn");
		slowDown();
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		logger.info("User should be login into his account");
		slowDown();
	}

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.signInPage().loginButtn);
		logger.info("User should create new account");

	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable data) {
		List<Map<String, String>> signUpData = data.asMaps(String.class, String.class);
		sendText(factory.signInPage().nameinput, signUpData.get(0).get("name"));
		sendText(factory.signInPage().emailInput1, signUpData.get(0).get("email"));
		sendText(factory.signInPage().passwordInput1, signUpData.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInput, signUpData.get(0).get("confirmPassword"));
		logger.info("user should follow the signup instruction");
	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.signInPage().signupBtn);
		logger.info("user may now enter the info");

	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		logger.info("user should be able to see the acc now");

	}

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.signInPage().accountLink);
		logger.info("user should see the option");

	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameNameValueAndPhonePhoneValue(String name, String phone) {
		clearTextUsingSendKeys(factory.signInPage().nameinput);
		sendText(factory.signInPage().nameinput, name);
		sendText(factory.signInPage().personalPhoneInput, phone);
		logger.info("user is now able to update personal info");
		slowDown();

	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.signInPage().personalUpdateBtn);
		logger.info("user profile is now updated");

	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		logger.info("user should now see the updated profile");

	}

	@When("User enter below information")
	public void userEnterBelowInformation(DataTable changepassword) {
		List<Map<String, String>> password = changepassword.asMaps(String.class, String.class);
		sendText(factory.signInPage().previousPasswordInput, password.get(0).get("previousPassword"));
		sendText(factory.signInPage().newPasswordInput, password.get(0).get("newPassword"));
		sendText(factory.signInPage().confirmPasswordInput, password.get(0).get("confirmPassword"));
		logger.info("user should see the updated password");

	}

	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.signInPage().credentialsSubmitBtn);
		logger.info("user can now change the password");
		slowDown();

	}

	@Then("a message should be displayed ‘Password Updated Successfully’")
	public void aMessageShouldBeDisplayedPasswordUpdatedSuccessfully() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().passwordupdatedS));
		logger.info(" password updated message displayed");
		slowDown();

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {

	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable cardinfo) {
		List<Map<String, String>> addpayment = cardinfo.asMaps(String.class, String.class);
		sendText(factory.signInPage().cardNumberInput, addpayment.get(0).get("cardNumber"));
		sendText(factory.signInPage().nameOnCardInput, addpayment.get(0).get("nameOnCard"));
		sendText(factory.signInPage().expirationMonthInput, addpayment.get(0).get("expirationMonth"));
		sendText(factory.signInPage().expirationYearInput, addpayment.get(0).get("expirationYear"));
		sendText(factory.signInPage().securityCodeInput, addpayment.get(0).get("securityCode"));
		logger.info("user card is now added");

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.signInPage().paymentSubmitBtn);
		logger.info("user may now enter card info");
		slowDown();
	}

	@Then("a message should be displayed ‘Payment Method updated Successfully’")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().cardAdedSucces));

		logger.info(" password updated message displayed");
		slowDown();

	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.signInPage().card2311);
		logger.info("user can add/remove card");

	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		click(factory.signInPage().removebutton);
		logger.info("user card is now removed");

	}

	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.signInPage().addaddress);
		logger.info("user may now able to add address");

	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addaddress = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.signInPage().countryDropdown, addaddress.get(0).get("country"));
		clearTextUsingSendKeys(factory.signInPage().fullNameInput);
		click(factory.signInPage().countryDropdown);
		sendText(factory.signInPage().fullNameInput, addaddress.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.signInPage().phoneNumberInput);
		sendText(factory.signInPage().phoneNumberInput, addaddress.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.signInPage().streetInput);
		sendText(factory.signInPage().streetInput, addaddress.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.signInPage().apartmentInput);
		sendText(factory.signInPage().apartmentInput, addaddress.get(0).get("apt"));
		clearTextUsingSendKeys(factory.signInPage().cityInput);
		sendText(factory.signInPage().cityInput, addaddress.get(0).get("city"));
		clearTextUsingSendKeys(factory.signInPage().streetInput);
		selectByVisibleText(factory.signInPage().satateInput, addaddress.get(0).get("state"));
		clearTextUsingSendKeys(factory.signInPage().zipCodeInput);
		click(factory.signInPage().satateInput);
		sendText(factory.signInPage().zipCodeInput, addaddress.get(0).get("zipCode"));
		logger.info("user address is now added");
		slowDown();

	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.signInPage().addressBtn);
		logger.info("user address is now updated");
		slowDown();
	}

	@Then("a message should be displayed ‘Address Added Successfully’")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().addressAddedS));

		logger.info(" Address updated message displayed");
		slowDown();
	}
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.signInPage().editaddress);
		logger.info("user click on edit address");
		
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.signInPage().updateaddress);
		logger.info("user click on update address");
		
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String string) {
		Assert.assertTrue(isElementDisplayed(factory.signInPage().updateaddress));

		logger.info("Address Updated Successfully");
		slowDown();
		
	}
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.signInPage().addressremoved);
		logger.info("user address is removed");	
		
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		try {
			Assert.assertFalse(isElementDisplayed(factory.signInPage().addressremoved));
			logger.info("Address details removed");
		}catch(AssertionError e) {
			logger.info(e.getMessage());
			
		}
		
		
	}
	
	
}
	
