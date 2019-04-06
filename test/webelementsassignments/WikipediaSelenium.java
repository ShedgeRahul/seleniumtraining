package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WikipediaSelenium {
	WebDriver driver;
  @Test
  public void wikipedia() throws InterruptedException 
  {
	  driver.get("https://www.wikipedia.org/");
	  driver.findElement(By.partialLinkText("English")).click();
	 // driver.findElement(By.id("js-link-box-en")).click();
	  driver.findElement(By.id("searchInput")).sendKeys("Selenium");
	  driver.findElement(By.id("searchButton")).click();
	  Thread.sleep(3000);
	  
	  String heading = driver.findElement(By.id("firstHeading")).getText();
	  
	  if (heading.equals("Selenium"))
	  {
		  System.out.println("Heading is Selenium");
	  }
	  else
	  {
		  System.out.println("Selenium");
	  }
	  
	  String expectedTitle = "Selenium - Wikipedia";
	  String actualTitle = driver.getTitle();
	  assertEquals(actualTitle, expectedTitle,"Actual tital is not matching with ecpected title");
	  
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
