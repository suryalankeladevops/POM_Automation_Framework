package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
//	WebDriver driver;
	
	@FindBy(xpath="//textarea[@id='APjFqb']")
	WebElement searchBox;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	
	public Page2 dash() {
		System.out.println("Dashboard page");
		System.out.println(driver.getTitle());
		searchBox.sendKeys("test", Keys.ENTER);
		System.out.println(driver.getTitle());
		return new Page2(driver);
	}
	
}


