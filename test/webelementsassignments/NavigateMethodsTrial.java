package webelementsassignments;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NavigateMethodsTrial {
  WebDriver driver;
	
  @Test
  public void navigateMethods() throws InterruptedException
  {
	driver.navigate().to("http://the-internet.herokuapp.com/dropdown");
	Thread.sleep(3000);
	String pageSource = driver.getPageSource();
	System.out.println("driver.navigate().to");
	System.out.println("Current URL is "+driver.getCurrentUrl());
	System.out.println("Page Title is "+driver.getTitle());
	System.out.println("Pgaesource is  "+pageSource);
	
	driver.navigate().back();
	Thread.sleep(3000);
	System.out.println("driver.navigate().back()");
	System.out.println("Current URL is "+driver.getCurrentUrl());
	System.out.println("Page title is "+driver.getTitle());
	
	
	driver.navigate().refresh();
	System.out.println("driver.navigate().refresh()");
	driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
	Thread.sleep(3000);
	
	driver.navigate().forward();
	Thread.sleep(3000);
	String currentUrl = driver.getCurrentUrl();
	System.out.println("driver.navigate().forward()");
	System.out.println("Current URL is "+currentUrl);
	System.out.println("Current page title is "+driver.getTitle());
	
	driver.get("http://the-internet.herokuapp.com/");
	Thread.sleep(3000);
	System.out.println("driver.get(\"http://the-internet.herokuapp.com/\");");
	System.out.println("Current page title is "+driver.getTitle()+" Current URL is "+driver.getCurrentUrl());
		
	driver.navigate().back();
	System.out.println("driver.navigate().back()");
	Thread.sleep(3000);
	System.out.println("Current page title is "+driver.getTitle()+" Current URL is "+driver.getCurrentUrl());
		
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
