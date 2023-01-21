package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	
	By titleHeader=By.xpath("//*[@id='masthead']/div/div[1]/h1/a"); //header title 
	By navBar=By.id("primary-menu"); //Nav bar 
	By dropDown=By.xpath("//select[@id='dropdown-class-example']"); //drop down 
	By login=By.xpath("//a[contains(text(),'Log in')]"); // Login Button
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public WebElement getTitle() {
		return driver.findElement(titleHeader);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
	
	public WebElement getDropDown() {
		return driver.findElement(dropDown);
	}
	
	
	public WebElement getLoginBtn() {
		return driver.findElement(login);
	}
	
	

	
	
	
	
	
	

}
