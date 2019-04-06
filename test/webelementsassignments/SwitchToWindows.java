package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;

public class SwitchToWindows {
	WebDriver driver;
  
	@Test
  public void switchWindows() throws InterruptedException 
  {
	driver.get("http://cookbook.seleniumacademy.com/Config.html");
	System.out.println(" "+driver.getTitle());
	String parentWindow = driver.getWindowHandle();
	//System.out.println(" "+parentWindow);

	driver.findElement(By.id("helpbutton")).click();
	try
	{
		driver.switchTo().window("HelpWindow");
		Thread.sleep(3000);
	}
	catch (NoSuchWindowException e) 
	{
		fail("Window2 is not present ");
	}
	System.out.println(" "+driver.getTitle());
	driver.close();
	
	driver.switchTo().window(parentWindow);
	System.out.println(" "+driver.getTitle());
	Thread.sleep(3000);
	
	driver.findElement(By.id("chatbutton")).click();
	Set<String> allOpenWindowHandles = driver.getWindowHandles();
	
	for(String oneHandle: allOpenWindowHandles)
	{
		//System.out.println(" "+oneHandle);
		if(!oneHandle.equals(parentWindow))
		{
			driver.switchTo().window(oneHandle);
			System.out.println(" "+driver.getTitle());
			try
			{
				Thread.sleep(5000);
			//	driver.findElement(By.id("closebutton")).click();
				break;
			}
			catch(NoSuchElementException e)
			{
			//	fail("Close button not found at window2 ");
			}
		
		}
	}
	
	driver.findElement(By.id("closebutton")).click();
	
	driver.switchTo().window(parentWindow);
	System.out.println(" "+driver.getTitle());
	
	driver.findElement(By.id("visitbutton")).click();
	driver.switchTo().window("VisitUsWindow");
	System.out.println(" "+driver.getTitle());
	
	driver.switchTo().window(parentWindow);
	System.out.println(" "+driver.getTitle());
	
	driver.quit();
  }
 
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
  }

  //@AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}