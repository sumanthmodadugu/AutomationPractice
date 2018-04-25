package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	public static WebDriver driver;
	@BeforeClass
	public void configMEthod(){
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		    driver = new ChromeDriver();
		  
		
	}
	
	@BeforeMethod
	public void ConfigBMEthod(){
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com");
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		
	}
	@AfterMethod
	public void ConfigAMEthod(){
	
	}
	@org.testng.annotations.AfterClass
	public void ConfigAClass(){
		
		driver.quit();
}
}
