package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GetAllLinksFromPage 
{
	WebDriver driver;
	
  @Test
  public void allElemennts() 
  {
	  driver.get("https://www.flipkart.com");
	  driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	  List<WebElement> allElements = driver.findElements(By.tagName("a"));
	//  System.out.println(" "+allElements);
	  
	 for(WebElement oneElement: allElements)
	  {
		  System.out.println(oneElement.getText()+" - "+oneElement.getAttribute("href"));
		  
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
