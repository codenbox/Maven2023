package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;	
	}
	
	By email=By.xpath("//input[@id='user_login']"); //emailid 
	By password=By.id("user_pass");  //password 
	By loginbtn=By.xpath("//*[@id='wp-submit']");  //login
	By error=By.id("login_error");  //error string if you enter invalid userName or Password
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(loginbtn);
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(error);
	}
	
	
	
	

}
