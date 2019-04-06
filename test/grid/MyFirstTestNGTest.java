package grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTest 
{
	RemoteWebDriver driver;	
	
	@Test
  public void seleniumExampleLogin() 
	{
		driver.get("http://selenium-examples.nichethyself.com/");
		driver.manage().window().maximize();
	
	  WebElement username = driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();

		String expectedTitle = "My account";
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle))
			System.out.println("Login Testcase is Passed");
		else 
			System.out.println("Login Testcase is Failed");

		
		assertEquals(expectedTitle,actualTitle,"Login Testcase is Passed");
	}
  
  
  @BeforeMethod
  public void beforeMethod()  
  {
	  
		//	System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver-32bit.exe");
		//	driver = new FirefoxDriver();
			
			//driver = new InternetExplorerDriver();
			
	//		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		//	driver = new ChromeDriver();
			
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setBrowserName("chrome");
	  
	 
		  try {
			driver = new RemoteWebDriver(new URL("http://192.168.0.131:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	  
	 	
  }

  @AfterMethod
  public void afterMethod() 
  {
  driver.quit();
  }

}
