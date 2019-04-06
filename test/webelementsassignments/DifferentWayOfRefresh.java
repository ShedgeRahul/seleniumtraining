package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

//import org.apache.xml.utils.ThreadControllerWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DifferentWayOfRefresh 
{
	WebDriver driver;
	
  @Test
  public void refresh() throws InterruptedException 
  {
	 driver.get("https://www.toolsqa.com/automation-practice-form/");
	  
	 Thread.sleep(3000);
	 //First Refresh
	 driver.navigate().refresh();
	 System.out.println("First refresh is successful by navigate().refresh()");
	  
	 Thread.sleep(3000);
	//Second Refresh 
	 driver.get(driver.getCurrentUrl());
	 System.out.println("Secound refresh is successful by getCurrentUrl()");

	 
	 Thread.sleep(3000);
	 //Third Refresh
	 driver.findElement(By.name("firstname")).sendKeys(Keys.F5);
	 System.out.println("Third refresh is successful by (By.name(\"firstname\")).sendKeys(Keys.F5)");

	 
	 Thread.sleep(3000);
	//Forth Refresh
	 driver.navigate().to(driver.getCurrentUrl());
	 System.out.println("Fourth refresh is successful by navigate().to(driver.getCurrentUrl())");

	
	 Thread.sleep(3000);
	//Fifth Refresh
	 driver.findElement(By.name("firstname")).sendKeys("\\uE035");
	 System.out.println("Fifth refresh is successful by sendKeys(\"\\\\uE035\")");

	 
	 Thread.sleep(3000);
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
