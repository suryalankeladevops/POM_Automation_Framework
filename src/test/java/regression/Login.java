package regression;

import org.testng.annotations.Test;

import base.BaseTest;

public class Login extends BaseTest{
@Test
public void firstTest() {
	System.out.println("This is first test log");
	//Below line for report
	//test.log(Status.INFO, "Clicking on Device tab...");
	home
	.dash()
	.testM();
}
}
