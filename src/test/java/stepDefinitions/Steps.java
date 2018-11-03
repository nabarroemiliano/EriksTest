package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

//			WebElement search = driver.findElement(By.id("lst-ib"));
//			search.sendKeys("shop eriks nl");
//			
//			search.sendKeys(Keys.ENTER);
			
			searchPage = pageObjectManager.getSearchPage();
			searchPage.search_page("shop eriks nl");
			
			
				
		    
		}

		@When("^click on the result http://shop\\.eriks\\.nl$")
		public void click_on_the_result_http_shop_eriks_nl() throws Throwable {
//
//			List<WebElement> links = driver.findElements(By.tagName("cite"));
//			
//			
//
//			if(links.size() > 0) {
//				for (WebElement link : links){
//					if(link.getText().contains("https://shop.eriks.nl")) {
//						link.click();
//						break;				}
//					
//				}
//			}
			
			
			searchPage.select_page("https://shop.eriks.nl");
		   
		}

		@When("^change the language to English$")
		public void change_the_language_to_English() throws Throwable {
			
			
//			driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();
//
//
//			WebDriverWait wait = new WebDriverWait(driver,20);
//
//			 WebElement language= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='right']/li[@id='lang-flipout-li']")));
//			
//			language.click();
//			
//			WebElement englishLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='flipout-target-lang']/div/div[2]/a[2]")));
//			
//			englishLanguage.click();
			
			homePage = pageObjectManager.getHomePage();
			
			homePage.accept_cookies();
			
			homePage.change_language(driver);
			
			
			
		   
		}
		
		
		@When("^enter 'loctite' in the search input box$")
		public void enter_loctite_in_the_search_input_box() throws Throwable {
		    
//			WebElement productSearch = driver.findElement(By.id("searchTerm"));
//			productSearch.sendKeys("loctite");
//			productSearch.sendKeys(Keys.ENTER);
			
			homePage.search_product("loctite");
			
		 
		}

		@Then("^check if the product 'LOCTITE	Loctite	(\\d+)-(\\d+)	GR' is present in the results$")
		public void check_if_the_product_LOCTITE_Loctite_GR_is_present_in_the_results(int arg1, int arg2) throws Throwable {
			
//			String productName;
//			List<WebElement> results = driver.findElements(By.xpath("//div[@class='product-item']"));
//			if(results.size() > 0) {
//				for(WebElement result : results) {
//					WebElement productLink = result.findElement(By.xpath("div[@class='product-title']/a/span"));
//					productName = productLink.getText();
//				
//					if(productName.contains("LOCTITE 7414 Torque Marque 50 ml")) {
//					productLink.click();
//					break;
//				}
//			}
//			}
		    
			
			productListingPage = pageObjectManager.getProductListingPage();
			
			productListingPage.search_product("LOCTITE 7414 Torque Marque 50 ml");
			
			driver.quit();
		}

}
