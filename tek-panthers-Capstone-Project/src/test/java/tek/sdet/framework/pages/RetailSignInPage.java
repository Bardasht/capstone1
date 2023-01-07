package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
		@FindBy( id = "signinLink")
		public  WebElement signInBttn;
		
		@FindBy( id = "email")
		public  WebElement emailInput;
		
		@FindBy( id="password")
		public  WebElement passwordInput;
		
		@FindBy( id="loginBtn")
		public  WebElement loginBttn;
		
		@FindBy( id="newAccountBtn")
		public  WebElement loginButtn;
		
		@FindBy( id="nameInput")
		public  WebElement nameinput;
		
		@FindBy( id="emailInput")
		public  WebElement emailInput1;
		
		@FindBy( id="passwordInput")
		public  WebElement passwordInput1;
		
		@FindBy( id="confirmPasswordInput")
		public  WebElement confirmPasswordInput;
		
		@FindBy( id="signupBtn")
		public  WebElement signupBtn;
		@FindBy( id="accountLink")
		public  WebElement accountLink;
		@FindBy( id="personalPhoneInput")
		public  WebElement personalPhoneInput;
		@FindBy( id="personalUpdateBtn")
		public  WebElement personalUpdateBtn;
		@FindBy( id="previousPasswordInput")
		public  WebElement previousPasswordInput;
		@FindBy( id="newPasswordInput")
		public  WebElement newPasswordInput;
		@FindBy( id="credentialsSubmitBtn")
		public  WebElement credentialsSubmitBtn;
		
		@FindBy(xpath ="//div[text()='Password Updated Successfully']")
		public WebElement passwordupdatedS;
		@FindBy(xpath ="//div//p[text()='Add a payment method']']")
		public WebElement addpayment;
		
		@FindBy( id="cardNumberInput")
		public  WebElement cardNumberInput;
		
		@FindBy( id="nameOnCardInput")
		public  WebElement nameOnCardInput;
		
		@FindBy( id="expirationMonthInput")
		public  WebElement expirationMonthInput;
		
		@FindBy( id="expirationYearInput")
		public  WebElement expirationYearInput;
		
		@FindBy( id="securityCodeInput")
		public  WebElement securityCodeInput;
		
		@FindBy( id="paymentSubmitBtn")
		public  WebElement paymentSubmitBtn;
		
		@FindBy(xpath ="//div//div[text()='Payment Method added sucessfully']")
		public WebElement cardAdedSucces;
		
		@FindBy(xpath = "//div[@class='account__payment-sub']")
		public  WebElement card2311;
		
		@FindBy(xpath ="//button[text()='remove']")
		public WebElement removebutton;
		
		@FindBy(xpath ="//div[@class='account__address-new']")
		public WebElement addaddress;
		
		@FindBy( id="countryDropdown")
		public  WebElement countryDropdown;
		
		@FindBy( id="fullNameInput")
		public  WebElement fullNameInput;
		
		@FindBy( id= "phoneNumberInput")
		public  WebElement phoneNumberInput;
		
		@FindBy( id= "streetInput")
		public  WebElement streetInput;
		
		@FindBy( id= "cityInput")
		public  WebElement cityInput;
		
		@FindBy( id= "apartmentInput")
		public  WebElement apartmentInput;
		
		@FindBy( xpath= "//select[@name='state']")
		public  WebElement satateInput;
		
		@FindBy( id= "zipCodeInput")
		public  WebElement zipCodeInput;
		
		@FindBy( id= "addressBtn")
		public  WebElement addressBtn;
		
		@FindBy(xpath ="//div//div[text()='Address Added Successfully']")
		public WebElement addressAddedS;
		
		@FindBy( xpath= "//button[text()='Edit']")
		public  WebElement editaddress;
		
		@FindBy( xpath= "//button[text()='Update Your Address']")
		public  WebElement updateaddress;
		
		@FindBy( xpath= "//div[text()='Address Updated Successfully']")
		public  WebElement AddressUpdatedSuccessfully;
		
		@FindBy( xpath= "//button[text()='Remove']")
		public  WebElement addressremoved;
		
		
		
		
		//span[text()='Add to Cart']
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
