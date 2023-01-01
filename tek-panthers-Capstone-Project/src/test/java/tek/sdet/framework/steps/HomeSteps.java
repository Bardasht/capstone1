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
		click(factory.signInPage().allDepartments);
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
		List<WebElement> dept = factory.signInPage().sideBar;
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
		List<WebElement> dept = factory.signInPage().sideBar;
		for (int i = 0; i < departmentOptions.get(0).size(); i++) {

			for (WebElement element : dept) {
				if (element.getText().equals(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(element.isDisplayed());
					logger.info(element.getText() + " is presnt");
				}}
			}		}
	@When("User change the category to {string}")
  	public void userChangeTheCategoryTo(String smartHome) {
		sendText(factory.signInPage().allDepartments, smartHome);
		logger.info(smartHome + " was selected from the drop down");
		slowDown();
	}
//    	@When("User click on Search icon")
//    	public void userClickOnSearchIcon() {
//    		click(factory.signInPage().search);
//    		slowDown();
//    		click(factory.signInPage().smartHome);
//    		logger.info("user click on search button");
//    	}	
//    	@When("User search for an item {string}")
//    	public void userSearchForAnItem(String value) {
//    		click(factory.signInPage().KasaOutDoorSmartPlug);
//    		logger.info("User should click on the item");
//    		slowDown();
//    	}
    		
	 			
    	@When("User click on item")
    	public void userClickOnItem() {
    		waitTillPresence(factory.signInPage().KasaOutDoorSmartPlug);
    		click(factory.signInPage().KasaOutDoorSmartPlug);
    		logger.info("user clicked on item");
    		
    		
    	}
    	@When("User select quantity {string}")
    	public void userSelectQuantity(String qty) {
    		selectByVisibleText(factory.signInPage().quantityselection,qty);	
    		logger.info("user selected quantity" + qty);
    		
   	}
    	@When("Userclick add to Cart button")
    	public void userclickAddToCartButton() {
    		click(factory.signInPage().addToCartButton);
    		logger.info("user clicked add to cart button");
    		
    	}
    	@Then("the cart icon quantity should change to {string}")
    	public void theCartIconQuantityShouldChangeTo(String expectedQuantity) {
    		Assert.assertEquals(expectedQuantity,factory.signInPage().cartQuantity.getText() );
    		logger.info("the cart icon quantity changed to " + expectedQuantity);
    	}
    		


	}



