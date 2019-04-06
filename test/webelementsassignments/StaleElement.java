package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class StaleElement {
	WebDriver driver;
	@Test
  public void nestedFrames() 
	{
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		try 
		{
		driver.switchTo().frame("frame-top");
		}
		catch (NoSuchFrameException e) 
		{
			fail("frame-top is not found");
		}
		
		try 
		{
		driver.switchTo().frame("frame-left");
		}
		catch (NoSuchFrameException e) 
		{
			fail("frame-left is not found");
		}
		
		String text1 = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println(" "+text1);
		
		driver.switchTo().defaultContent();
	
		try 
		{
		driver.switchTo().frame("frame-top");
		}
		catch (NoSuchFrameException e) 
		{
			fail("frame-top is not found");
		}
		
		List<WebElement> allFrames = driver.findElements(By.tagName("frame"));
		for(WebElement frame: allFrames)
		{
			driver.switchTo().frame(frame); 
			if(driver.getPageSource().contains("MIDDLE"))
			{
				System.out.println("MIDDLE");
			//	String text2 = driver.findElement(By.id("content")).getText();
			//	System.out.println(" "+text2);
				break;
			}
			else
				driver.switchTo().defaultContent();
		}
			
		
		
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
