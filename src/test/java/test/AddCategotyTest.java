package test;

import java.util.Locale.Category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.AddCatagoryPage;
import page.BasePage;
import util.BrowserFactory;

public class AddCategotyTest {
	
	WebDriver driver;
	AddCatagoryPage catagoryPage;

	String addCatagory = "Ruby Kwatra";
	
	
	@BeforeTest
	public void init() {
	driver = BrowserFactory.init();
	}
	
	@Test(priority=1)
	public void userShouldBeAbleToAddNewCatagoryItem() {
		catagoryPage = PageFactory.initElements(driver, AddCatagoryPage.class);
		catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		catagoryPage.userClickOnAddCatagoryButton();
		catagoryPage.validateNewCatagoryIsAdded();
		
	}
	
	  @Test(priority=2)
	  public void userShouldBeAbleToValidateTheMonths() {
		  catagoryPage.selectFromDropdown(AddCatagoryPage.VALIDATE_MONTH_NAMES);
	  }
	  @Test(priority=3)
	  public void duplicateCatagoryInsertion() {
		  catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		  catagoryPage.userClickOnAddCatagoryButton();
		  catagoryPage.userShouldBeAbleToAddNewCatagoryItem(addCatagory);
		  catagoryPage.userClickOnAddCatagoryButton();
		  Assert.assertEquals(AddCatagoryPage.addNewItem, "Ruby Kwatra new Catagory");
		
	     BrowserFactory.tearDown();
		
		
		
	}

}
