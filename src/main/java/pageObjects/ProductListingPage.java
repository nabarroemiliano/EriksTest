package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='product-item']"))
	private List<WebElement> results;
	
//	@FindBy(how = How.XPATH, using = "div[@class='product-title']/a/span" )
//	private WebElement productLink ;
	
	
	public void search_product(String name) {
		String productName;
		if(results.size() > 0) {
			for(WebElement result : results) {
				WebElement productLink = result.findElement(By.xpath("div[@class='product-title']/a/span"));
				productName = productLink.getText();
			
//				ACA HAY QUE METER UN ASSERT
				if(productName.contains(name)) {
				productLink.click();
				break;
			}
				
				
				
		}
		}
	}

}
