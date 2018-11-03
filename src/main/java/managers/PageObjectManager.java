package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;

public class PageObjectManager {
	
	private WebDriver driver;
	SearchPage searchPage;
	ProductListingPage productListingPage;
	HomePage homePage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage(){
		 
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
 
	}
	
	
	public SearchPage getSearchPage() {
		return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;
	}
	
	public ProductListingPage getProductListingPage() {
		return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
	}
	

}
