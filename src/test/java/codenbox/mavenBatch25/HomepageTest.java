package codenbox.mavenBatch25;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class HomepageTest extends Base{
	
	
	@Test (priority=0)
	public void landingPageTitle() {
		LandingPage l=new LandingPage(driver);
		String actualtitle=l.getTitle().getText(); 
		Assert.assertEquals(actualtitle, "CodenBox AutomationLab");	
	}
	
	
	@Test (priority=1)
	public void basePageNavigationBar() {
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
	}
	
	
	@Test (priority=2)
	public void selectDropdown() throws InterruptedException {
		LandingPage l=new LandingPage(driver);
		WebElement dropDown=l.getDropDown(); //locator for the drop down
		Select s=new Select(dropDown);
		s.selectByVisibleText("Selenium");
		Thread.sleep(2000l);
		Assert.assertTrue(dropDown.isDisplayed());
		
	}
	
	
	
	

}
