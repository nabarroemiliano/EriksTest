package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class SearchPage {
	
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}

	
	@FindBy(how = How.ID, using ="lst-ib")
	private WebElement search;
	
	@FindAll(@FindBy(how = How.TAG_NAME, using = "cite"))
	private List<WebElement> links;
	
	public void navigateTo() {
		driver.get(configFileReader.getApplicationUrl());
	}
	
	public void search_page(String name) {
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
	}
	
	public void select_page(String webPage) {
		
		if(links.size() > 0) {
			for (WebElement link : links){
				if(link.getText().contains(webPage)) {
					link.click();
					break;		
					}
				
			}
		}
	}
}
