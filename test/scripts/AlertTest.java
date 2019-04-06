package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertTest
{
	WebDriver driver;
	
  @Test
  public void handleAlert() throws InterruptedException {
	  driver.get("http://selenium-examples.nichethyself.com/");
	  WebElement username = driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");
		//driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		Alert myAlert; 
		try
		{			
		myAlert = driver.switchTo().alert();
		System.out.println(" "+myAlert.getText());
		//assert.Equals(myAlert.getText(),"Please enter Password");
		Thread.sleep(3000);
		myAlert.accept();
		}
		catch(NoAlertPresentException e)
		{
			fail("No Alert present");
		}
  }
  
  

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }


}
