package codenbox.mavenBatch25;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	@Test (priority=3)
	public void doLogin() throws InterruptedException {
		LandingPage l=new LandingPage(driver);
		l.getLoginBtn().click();  //click on login button on landingPage
		
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(2000l);
		lp.getEmail().sendKeys("test@test.com");
		lp.getPassword().sendKeys("123344kand");
		lp.getLogin().click();
		String actualError=lp.getErrorMsg().getText();  //will find error string
		Assert.assertEquals(actualError, "Unknown email address. Check again or try your username.");
		
	}

}
