package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AllGooglepageLinks 
{
  WebDriver driver;
//	@Test
  public void googleLinks() 
  {
	  
		List<WebElement> googleLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement link:googleLinks)
		{
			System.out.println(link.getText()+" - "+link.getAttribute("href"));
		}
		
		for(int i=0; i<googleLinks.size(); i++)
		{
			
	System.out.println(googleLinks.get(i).getText()+" - "+googleLinks.get(i).getAttribute("href"));
			
		}
  }
  
	@Test
public void waitTest() throws InterruptedException
 { 
	 driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	 //Thread.sleep(9000);
	 driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();;
	 String str = driver.findElement(By.id("finish")).getText();
	 
	 assertEquals(str, "Hello World!");
}
		
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
