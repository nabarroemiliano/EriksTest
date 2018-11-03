package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {

	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		WebElement search = driver.findElement(By.id("lst-ib"));
		search.sendKeys("shop eriks nl");
		
		search.sendKeys(Keys.ENTER);
			
		
		List<WebElement> links = driver.findElements(By.tagName("cite"));
//		items.get(0).click();

		if(links.size() > 0) {
			for (WebElement link : links){
				if(link.getText().contains("https://shop.eriks.nl")) {
					link.click();
					break;				}
				
			}
		}
		
	
		
		driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();


		WebDriverWait wait = new WebDriverWait(driver,20);

		 WebElement language= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='right']/li[@id='lang-flipout-li']")));
		
		language.click();
		
		WebElement englishLanguage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flipout-target-lang']/div/div[2]/a[2]")));
		
		englishLanguage.click();
		
		
	
		WebElement productSearch = driver.findElement(By.id("searchTerm"));
		productSearch.sendKeys("loctite");
		productSearch.sendKeys(Keys.ENTER);
		
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='product-item']"));
		
		if(results.size() > 0) {
			for(WebElement result : results) {
				WebElement productLink = result.findElement(By.xpath("div[@class='product-title']/a/span"));
				productName = productLink.getText();
			
				if(productName.contains("LOCTITE 7414 Torque Marque 50 ml")) {
				productLink.click();
				break;
			}
		}
		}
		
//			driver.quit();
	
	}

}
