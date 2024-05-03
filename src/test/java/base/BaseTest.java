package base;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.jayway.jsonpath.internal.Utils;

import io.restassured.path.json.JsonPath;
import pages.HomePage;

public class BaseTest extends Utilities{

	public static WebDriver driver;
	protected HomePage home;
	protected String URL;
	
	@BeforeClass
	protected void initializeTestData() {
		JsonPath url=utilities.Utils.getEnvUrl();
		System.out.println(url.toString());
		try {
			String env=System.getProperty("env");
			URL=url.getString(env);
		}
//		catch (){
//			
//		}
		finally {
			System.out.println("This is finally block after data load");
		}
	}
	
	@BeforeMethod
	protected void beforeTest() {
		System.out.println("This is @before method");
		driver=utilities.Utils.getEdge();
		driver.manage().window().maximize();
		driver.get(getEnv());
		System.out.println("Navigated to : "+driver.getTitle());
		home=new HomePage(driver);
	}
	@AfterMethod
	protected void afterTesr() {
		System.out.println("After method");
		driver.quit();
	}
	
	private String getEnv() {
		String env=System.getProperty("env");
		return URL;
	}
}
