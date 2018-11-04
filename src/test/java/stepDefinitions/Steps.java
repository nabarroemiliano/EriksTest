package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;

public class Steps {

	WebDriver driver;
	SearchPage searchPage;
	ProductListingPage productListingPage;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;

		@When("^User open google\\.com$")
		public void user_open_google_com() throws Throwable {
		    	
			
			configFileReader= new ConfigFileReader();
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + configFileReader.getDriverPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			pageObjectManager = new PageObjectManager(driver);
			driver.get("http://www.google.com");
			
			
		}

		@When("^he search for 'shop	eriks	nl'$")
		public void he_search_for_shop_eriks_nl() throws Throwable {

			
			searchPage = pageObjectManager.getSearchPage();
			searchPage.search_page("shop eriks nl");
			
    
		}

		@When("^click on the result http://shop\\.eriks\\.nl$")
		public void click_on_the_result_http_shop_eriks_nl() throws Throwable {
		
			searchPage.select_page("https://shop.eriks.nl");
		   
		}

		@When("^change the language to English$")
		public void change_the_language_to_English() throws Throwable {
			
			
			homePage = pageObjectManager.getHomePage();
			
			homePage.accept_cookies();
			
			homePage.change_language(driver);
	 
		}
		
		
		@When("^enter 'loctite' in the search input box$")
		public void enter_loctite_in_the_search_input_box() throws Throwable {
		    

			
			homePage.search_product("loctite");
			
		 
		}

		@Then("^check if the product 'LOCTITE	Loctite	(\\d+)-(\\d+)	GR' is present in the results$")
		public void check_if_the_product_LOCTITE_Loctite_GR_is_present_in_the_results(int arg1, int arg2) throws Throwable {
			

		    
			
			productListingPage = pageObjectManager.getProductListingPage();
			
			Assert.assertTrue(productListingPage.search_product(configFileReader.getProductNameToSearch()));
			
//			driver.quit();
		}

}
