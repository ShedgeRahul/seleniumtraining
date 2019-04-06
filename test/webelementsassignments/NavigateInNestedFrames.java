package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NavigateInNestedFrames 
{
	WebDriver driver;
	@Test
  public void nestedFrames() 
	{
		driver.get("http://the-internet.herokuapp.com/frames");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		try
		{
			driver.switchTo().frame("frame-top");
		}
		catch (NoSuchFrameException e) 
		{
			System.out.println("frame-top not found ");
		}

		try
		{
			driver.switchTo().frame("frame-left");
		}
		catch (NoSuchFrameException e) 
		{
		System.out.println("frame-left not found ");
		}
		
		String text2 = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println(" "+text2);
 
		driver.switchTo().parentFrame();
		try
		{
			driver.switchTo().frame("frame-middle");
		}
		catch (NoSuchFrameException e) 
		{
		System.out.println("frame-middle not found ");
		}
		String text3 = driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(" "+text3);
		
		driver.switchTo().parentFrame();
		try
		{
			driver.switchTo().frame("frame-right");
		}
		catch (NoSuchFrameException e) 
		{
		System.out.println("frame-right not found ");
		}
		String text4 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		System.out.println(" "+text4);
	
	driver.switchTo().defaultContent();
	try
	{
	driver.switchTo().frame("frame-bottom");
	}
	catch (NoSuchFrameException e) 
	{
	System.out.println("frame-bottom not found ");
	}
	
	String text5 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
	System.out.println(" "+text5);
	
	
	
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
