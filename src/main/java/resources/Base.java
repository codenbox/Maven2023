package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeMethod()
	//@BeforeClass(alwaysRun=true)
	public void initializerDriver() throws IOException {
		prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\Sarif\\Desktop\\MavenBatch25\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fs); //load will load the properties file due to read the data
		String browserName=prop.getProperty("browser");  //chrome 
		
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Selenium\\chromedriver.exe");
			 // Set up the WebDriverManager for chrome driver
	        WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Selenium\\geckodriver.exe");
			 // Set up the WebDriverManager for chrome driver
	        WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Selenium\\geckodriver.exe");
			 driver=new EdgeDriver();
		}
		
		
		driver.get(prop.getProperty("url"));
		
		//driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().deleteAllCookies();
		
		
	}
	
	
	public void getScreenshot(String result) throws IOException {
		// Web Driver take the screenshot as a file and save in virtually in src variable.
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copy the file from src and put in your local machine with the name of failed
		// test class
		FileUtils.copyFile(srcFile, new File("C:\\Users\\Sarif\\Desktop\\MavenBatch25\\screenshotTest\\" + result + "screenshot.png"));

	}
	
	//@AfterClass(alwaysRun=true)
	@AfterMethod()
	public void tearDown() {
		driver.quit();
		driver=null; // All the objects are alive in driver's memory that can full. So clean driver.
	}
	
	
	
	
	

}
