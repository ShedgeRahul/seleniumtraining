package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class KeyPress 
{
	WebDriver driver;

@Test
  public void keyDown() throws InterruptedException 
  {
	 driver.get("https://www.google.com");
	 String parentWindowHandle = driver.getWindowHandle();
	 System.out.println(" "+parentWindowHandle);
	 WebElement link = driver.findElement(By.xpath("//a[text()='Gmail']"));
	 
	  Actions builder = new Actions(driver);
	 builder.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).build().perform();

/*	 					builder
	 					.keyDown(Keys.CONTROL)
	 					.keyDown(Keys.TAB)
	 					.keyUp(Keys.TAB)
	 					.keyUp(Keys.CONTROL)
	 					.build().perform();
	*/ 
	 Set<String> allOpenWindowHandles = driver.getWindowHandles();
	 System.out.println(" "+driver.getTitle());
	 for(String oneHandle : allOpenWindowHandles)
	 {
		 if(!(oneHandle.equals(parentWindowHandle)))
		 {
			 driver.switchTo().window(oneHandle);
			 System.out.println(" "+driver.getTitle());
		 }
	 }
	 
	 driver.findElement(By.xpath("//body/div[2]/div[1]/div[5]/ul[1]/li[2]/a")).click();
	 

	 
	 Set<String> allOpenWindowHandles2 = driver.getWindowHandles();
	// System.out.println(" "+driver.getTitle());
	 for(String oneHandle : allOpenWindowHandles2)
	 {
		 if(!(oneHandle.equals(parentWindowHandle)))
		 {
			 driver.switchTo().window(oneHandle);
			System.out.println(" "+driver.getTitle());
			try
			{
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rshedge");
			}
			catch (NoSuchElementException e) 
			{
			
			}
		 }
	 }
	 
	 driver.switchTo().window(parentWindowHandle);
	 System.out.println(" "+driver.getTitle());
	 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("jobs in Selenium");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
	 Thread.sleep(3000);

	 //builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
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
