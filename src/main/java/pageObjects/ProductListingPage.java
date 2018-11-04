package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	
	
	@FindBy(how = How.ID, using = "pageSize")
	private WebElement pageSize;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='product-item']"))
	private List<WebElement> results;
	
	@FindBy(how = How.XPATH, using = "//div[@class='result-pagination slim']/a/span[1]")
	private WebElement nextPage;
	
	WebDriver driver;
	
	WebElement productLink;
	
	String productName;
	
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean search(String name) {
				
		results.clear();
		reload_results();
		if(results.size() > 0) {
			for(WebElement result : results) {
				productLink = result.findElement(By.xpath("div[@class='product-title']/a/span"));
				productName = productLink.getText();
			

				if(productName.contains(name)) {
				return true;
				
				}
	
				
			}
			
			
		}
		return false;	
	
		
	}
	
	public List<WebElement> reload_results(){
		
		
		results = driver.findElements(By.xpath("//div[@class='product-item']"));
		
		return results;
	}
	
	
	public int getPages() {
		
		String pages = driver.findElement(By.xpath("//div[@class='result-pagination slim']/div")).getText();
		
		String s1 = pages.substring(pages.indexOf("/ ")+1);
		return Integer.parseInt(s1.trim());
		
	}
	
	public boolean search_product(String name) {
		
		Select dropdown= new Select(pageSize);
		dropdown.selectByVisibleText("200");
		
		int n = getPages();
		
		
		for(int i=1; i<n+1; i++) {
			
			if(search(name)) {
				productLink.click();
				return true;
				
			}
			
			nextPage.click();
			

		}
		return false;	
		
	}

}
