package utilities;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.restassured.path.json.JsonPath;

public class Utils {

	public static String getTestData() {
		System.out.println(System.getProperty("user.dir"));
		return System.getProperty("user.dir") + "/TestData/";
	}

	public static JsonPath getEnvUrl() {
		JsonPath json = new JsonPath(new File(getTestData() + "env.json"));
		System.out.println(json);
		return json;
	}

	private static String getEdgedriverPath() {
		String win = System.getProperty("user.dir") + "/BrowserDrivers/edgedriver_win/msedgedriver.exe";
		return win;
	}

	public static WebDriver getEdge() {
		System.setProperty("webdriver.edge.driver", getEdgedriverPath());
		EdgeOptions edgeoptions = new EdgeOptions();
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.AUTODETECT);
		edgeoptions.setCapability("proxy", proxy);
		return new EdgeDriver();

	}

	// Below code added screenshot and used in BaseTest java class
	public static String captureScreenshot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/ErrorScreenshots/" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}
}
