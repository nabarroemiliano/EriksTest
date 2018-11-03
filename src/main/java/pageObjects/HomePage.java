package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	 WebDriverWait wait;
	 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);
	}
	
	@FindBy(how = How.ID, using = "CybotCookiebotDialogBodyButtonAccept")
	private WebElement cookies;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='right']/li[@id='lang-flipout-li']")
	private WebElement language;
	
	@FindBy(how = How.XPATH, using = "//div[@id='flipout-target-lang']/div/div[2]/a[2]")
	private WebElement englishLanguage;
	
	@FindBy(how = How.ID, using = "searchTerm")
	private WebElement productSearch;
	
	
	public void accept_cookies() {
		cookies.click();
	}
	
	
	public void change_language(WebDriver driver) {
		
		wait.until(ExpectedConditions.elementToBeClickable(language));
		
		language.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(englishLanguage));
		
		englishLanguage.click();
	}
	
	public void search_product(String name) {
		productSearch.sendKeys(name);
		productSearch.sendKeys(Keys.ENTER);
		
		
	}
	
	
	
}
