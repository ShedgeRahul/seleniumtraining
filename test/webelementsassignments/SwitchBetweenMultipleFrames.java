package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SwitchBetweenMultipleFrames {
  WebDriver driver;
	@Test
  public void switchToFrame() throws InterruptedException 
	{
		driver.get("https://www.toolsqa.com/iframe-practice-page");
		System.out.println(" "+driver.getTitle());
		try
		{
		driver.switchTo().frame("IF1");
		}
		catch (NoSuchFrameException e) 
		{
			Assert.fail("Frame1 not found ");
		}
		
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rahul");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shedge");
	Thread.sleep(3000);
	
	driver.switchTo().defaultContent();
	System.out.println(" "+driver.getTitle());
	
	try
	{
	driver.switchTo().frame("iframe2");
	}
	catch(NoSuchFrameException e)
	{
		fail("FRAME2 not found ");
	}
	
	String text = driver.findElement(By.xpath("/html/body/h1")).getText();
	System.out.println(" "+text);
			 
	assertEquals(text, "Error establishing a database connection");
	
	driver.switchTo().defaultContent();
	System.out.println(" "+driver.getTitle());
	}

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
  }

 @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}

