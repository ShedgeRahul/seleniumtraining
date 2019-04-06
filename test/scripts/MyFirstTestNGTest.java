package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTest 
{
	WebDriver driver;	
	
	@Test
  public void seleniumExampleLogin() 
	{
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
			
			System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://selenium-examples.nichethyself.com/");
			driver.manage().window().maximize();
			
  }

  @AfterMethod
  public void afterMethod() 
  {
  driver.quit();
  }

}
