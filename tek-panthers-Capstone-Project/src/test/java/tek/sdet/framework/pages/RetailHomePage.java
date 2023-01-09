package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {
    
    public RetailHomePage() {
        PageFactory.initElements(getDriver(), this);
    }

   @FindBy(xpath = "//a[@class='top-nav__logo active']") 
    public WebElement logo;
   @FindBy( id = "search")
	public  WebElement allDepartments;
	
	@FindBy( xpath= "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBar;
	
	@FindBy(id="searchBtn")
	public  WebElement searchBtn;
	
	@FindBy(id="searchInput")
	public  WebElement searchInput;
	

	@FindBy( xpath= "//select//option[text()='Smart Home']")
	public  WebElement smartHome;
	
	
	@FindBy( className ="products__name")
	public  WebElement KasaOutDoorSmartPlug;
	
	@FindBy( xpath= "//option[text()='2']")
	public  WebElement quantityselection;
	
	@FindBy( xpath= "//span[text()='Add to Cart']")
	public  WebElement addToCartButton;
	
	@FindBy(id="cartQuantity")
	public  WebElement cartQuantity;
	
	@FindBy(id="searchBtn")
	public  WebElement search;	
	
	@FindBy(className = "products__name")

	public WebElement itemkassaoutdoor;
	
	
	@FindBy(id="cartBtn")
	public  WebElement cartBtn;
	
	@FindBy(id="proceedBtn")
	public  WebElement proceedBtn;
	
	@FindBy(id="addAddressBtn")
	public  WebElement addaddressBtn;
	
	@FindBy(id="addPaymentBtn")
	public  WebElement addpyBtn;
	
	@FindBy(id="paymentSubmitBtn")
	public  WebElement pysubmitBtn;
	
	@FindBy(id="placeOrderBtn")
	public  WebElement placeOrderBtn;
	
	
	
	@FindBy(id = "addAddressBtn")

	public WebElement addAddressBtn1;

	 

	@FindBy(id = "countryDropdown")

	public WebElement country;

	 

	@FindBy(id = "fullNameInput")

	public WebElement fullName;

	 

	@FindBy(id = "phoneNumberInput")

	public WebElement phoneNumberInput;

	 

	@FindBy(id = "streetInput")

	public WebElement streetInput;

	 

	@FindBy(id = "apartmentInput")

	public WebElement apartmentInput;

	 

	@FindBy(id = "cityInput")

	public WebElement cityInput;

	 

	@FindBy(xpath = "//select[@name='state']//self::select")

	public WebElement state;

	 

	@FindBy(id = "addressBtn")

	public WebElement addressBtn2;

	 

	@FindBy(id = "zipCodeInput")

	public WebElement zipCodeInput;

	 

	@FindBy(id = "addPaymentBtn")

	public WebElement addPaymentBtn;

	 

	@FindBy(id = "cardNumberInput")

	public WebElement cardNumberInput;

	 

	@FindBy(id = "nameOnCardInput")

	public WebElement nameOnCardInput;

	 

	@FindBy(id = "expirationMonthInput")

	public WebElement expirationMonthInput;

	 

	@FindBy(id = "expirationYearInput")

	public WebElement expirationYearInput;

	 

	@FindBy(id = "securityCodeInput")

	public WebElement securityCodeInput;

	 

	@FindBy(id = "paymentSubmitBtn")

	public WebElement paymentSubmitBtn;


	@FindBy(id = "addToCartBtn")

	public WebElement idAddtoTheCartBtn;
	

	 

	@FindBy(className = "Toastify")

	public WebElement orderPlacedSuccessfully;
	
	@FindBy( xpath= "//option[text()='5']")
	public  WebElement quantityselection5;
	

	@FindBy(id = "orderLink")

	public WebElement orderLink;
	
	@FindBy(id = "cancelBtn")

	public WebElement cancelBTN;
	
	
	
	
	@FindBy( xpath= "//div[@class='order__cancel-wrapper']")
	public  WebElement ordercancel;
	
	@FindBy( xpath= "//p[@class='order__item-name']")
	public  WebElement orderselect;
	

	
//	@FindBy(id = "reasonInput")
//	public WebElement reasonInput;
	
	
	
	//option[text()='Bought wrong item']
	
	@FindBy( xpath= "//option[text()='Bought wrong item']")
	public  WebElement wrongitem;
	
	 
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnBTN;
	
	
	@FindBy( xpath= "//p[text()='Your Order Has Been Cancelled']")
	public  WebElement YourOrderHasBeenCancelled;
	
	 
		@FindBy(id = "returnBtn")
		public WebElement returnBTN1;
		
		@FindBy( xpath= "//option[text()='FedEx']")
		public  WebElement fedex;
		
//		@FindBy(id = "orderSubmitBtn")
//		public WebElement orderreturn;
		
		
		@FindBy( xpath= "//p[text()='Return was successfull']")
		public  WebElement yourorderhasbeenreturned;
		
		@FindBy(id = "reviewBtn")
		public WebElement reviewitem;
		
		@FindBy(id = "headlineInput")
		public WebElement headlineinput;
		
		@FindBy(id = "descriptionInput")
		public WebElement descriptioninput;
		
		@FindBy(id = "reviewSubmitBtn")
		public WebElement reviewsubmitbtn;
		
		@FindBy( xpath= "//div[text()='Your review was added successfully']")
		public  WebElement Yourreviewwasaddedsuccessfully;
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	 
	
	

}
