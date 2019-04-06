package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class WaitAssignment2 {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void explicitWait() 
  {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  driver.findElement(By.xpath("//button[text()='Start']")).click();
	  //WebElement finish = driver.findElement(By.id("finish"));
	  WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
	  String actualText = finish.getText();
	  String expectedText = "Hello World!";
	  assertEquals(actualText, expectedText);
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	//  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
	  wait = new WebDriverWait(driver, 10);
	  	
  }

 @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}

