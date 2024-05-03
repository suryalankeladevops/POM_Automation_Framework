package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page2{
	WebDriver driver;
	@FindBy(css="div.product_label")
	WebElement productLabel;

	
	public Page2(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void testM() {
		System.out.println("page2");
		System.out.println(driver.getTitle());
	}
}

