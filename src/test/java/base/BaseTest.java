package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jayway.jsonpath.internal.Utils;

import io.restassured.path.json.JsonPath;
import pages.HomePage;

public class BaseTest extends utilities.Utils{

	public static WebDriver driver;
	protected HomePage home;
	protected String URL;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
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
	protected void afterTest() {
		System.out.println("After method");
		driver.quit();
	}
	
	private String getEnv() {
		String env=System.getProperty("env");
		return URL;
	}
	
	//-------------------------- Surya added------------------------------
	
	/*
	 * @BeforeSuite public static void removeReportFolder() throws IOException {
	 * System.out.println("Remove report folder"); String index =
	 * System.getProperty("user.dir") + "/Reports";
	 * System.out.println("index"+index); File file = new File(index); if
	 * (!file.exists()) { file.mkdir(); } else { file.delete(); if (!file.exists())
	 * { file.mkdir(); //file.delete(); } } }
	 * 
	 * @BeforeClass public void setUp() { // Initialise the HtmlReporter
	 * System.out.println("Inside Setup class"); String timeStamp = new
	 * SimpleDateFormat("dd-M-yyyy hh-mm-ss").format(new Date());
	 * System.out.println(timeStamp); htmlReporter = new
	 * ExtentHtmlReporter(System.getProperty("user.dir") +
	 * "/Reports/AutomationReport " +timeStamp+".html");
	 * 
	 * // Initialise ExtentReports and attach the HtmlReporter extent = new
	 * ExtentReports(); extent.attachReporter(htmlReporter);
	 * 
	 * // To add system or environment info by using the set SystemInfo method.
	 * extent.setSystemInfo("OS", "Windows"); extent.setSystemInfo("Environment",
	 * "QA"); extent.setSystemInfo("User Name", "612497366");
	 * 
	 * // configuration items to change the look and feel //
	 * htmlReporter.config().setChartVisibilityOnOpen(true);
	 * htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
	 * htmlReporter.config().setReportName("Automation Report"); //
	 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 * htmlReporter.config().setTheme(Theme.DARK); htmlReporter.config().
	 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"); }
	 * 
	 * @BeforeMethod public void beforeMethod(ITestResult result) { test =
	 * extent.createTest(result.getMethod().getMethodName(),
	 * result.getMethod().getDescription()); }
	 * 
	 * @AfterMethod public void getResult(ITestResult result) throws Exception {
	 * System.out.println("result.."+result); if (result.getStatus() ==
	 * ITestResult.FAILURE) {
	 * System.out.println("result.getstatus.."+result.getStatus());
	 * System.out.println("ITestResult.FAILURE.."+ITestResult.FAILURE);
	 * test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ",
	 * ExtentColor.RED)); test.fail(result.getThrowable());
	 * 
	 * String screenShotPath = utilities.Utils.captureScreenshot(driver,
	 * result.getName()); System.out.println("screenShotPath"+screenShotPath);
	 * System.out.println(screenShotPath); test.log(Status.FAIL,
	 * MarkupHelper.createLabel(result.getName() +
	 * " Test case FAILED due to below issues:", ExtentColor.RED));
	 * test.fail(result.getThrowable()); test.fail("Failure Snapshot below: " +
	 * test.addScreenCaptureFromPath(screenShotPath));
	 * 
	 * } else if (result.getStatus() == ITestResult.SUCCESS) {
	 * System.out.println("1"); System.out.println("Pass"+test.getStatus());
	 * System.out.println(test.getStatus()); System.out.println("2");
	 * 
	 * test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ",
	 * ExtentColor.GREEN)); } else if(result.getStatus() == ITestResult.SKIP){
	 * 
	 * System.out.println("skip"+test.getStatus()); // Baseclass.extenttest =
	 * Baseclass.extent.createTest(result.getMethod().getDescription()).
	 * assignCategory("SkipedTest"); // Baseclass.extenttest .log(Status.SKIP,
	 * result.getThrowable()); // Baseclass.extenttest .log(Status.SKIP,
	 * result.getMethod().getDescription()); // Baseclass.extenttest
	 * .log(Status.SKIP, MarkupHelper.createLabel(result.getName(),
	 * ExtentColor.YELLOW)); // Baseclass.extent.flush(); test.log(Status.SKIP,
	 * MarkupHelper.createLabel(result.getName() + " SKIPPED ",
	 * ExtentColor.ORANGE)); test.skip(result.getThrowable()); }
	 * 
	 * extent.flush();
	 * 
	 * }
	 */
	
	
}
