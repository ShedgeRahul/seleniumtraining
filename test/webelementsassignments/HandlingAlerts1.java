package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class HandlingAlerts1 
{
	WebDriver driver;
//	WebDriverWait wait;
	
  @Test
  public void alert1() throws InterruptedException
  {
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");  
	driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	Alert myAlert;
	
	try
	{
		myAlert = driver.switchTo().alert();
		System.out.println(" "+myAlert.getText());
		//Thread.sleep(3000);
		myAlert.accept();
	}
	catch (NoAlertPresentException e)
	{
		fail("accept Alert1 is failed ");
	}
	
	  WebElement text = driver.findElement(By.xpath("//p[@id='result']"));
	  String textColor = text.getCssValue("color");
	  //System.out.println(" "+textColor);
	  //Thread.sleep(3000);
	  assertEquals(textColor, "rgba(0, 128, 0, 1)");
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  try
	  {
		  myAlert = driver.switchTo().alert();
		//  Thread.sleep(3000);
		  myAlert.dismiss();
	  }
	  catch (NoAlertPresentException e) 
	  {
		  fail("dismiss Alert2 is failed ");
	  }
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  try
	  {
		  myAlert = driver.switchTo().alert();
		  System.out.println(" "+myAlert.getText());
		 // Thread.sleep(3000);
		  myAlert.accept();
	  }
	  catch (NoAlertPresentException e) 
	  {
		  fail("accept Alert2 is failed ");
	  }
	  
	  String text2 = driver.findElement(By.id("result")).getText();
			  System.out.println(" "+text2);
	 String textColor2 = driver.findElement(By.id("result")).getCssValue("color");
	  //System.out.println(" "+textColor2);
	 assertEquals(textColor2, "rgba(0, 128, 0, 1)");
	  
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  try
	  {
		  myAlert = driver.switchTo().alert();
		 // Thread.sleep(3000);
		  myAlert.dismiss();
	 }
	  catch (NoAlertPresentException e) 
	  {
		  fail("Dismmis Alert3 is failed ");	
	  }
	  
	  String text3 = driver.findElement(By.id("result")).getText();
	  System.out.println(" "+text3);
	  
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  try
	  {
	  myAlert = driver.switchTo().alert();
	  System.out.println(" "+myAlert.getText());
	  myAlert.sendKeys("Text entered in third alert by myAlert.sendKeys");
	  //Thread.sleep(3000);
	  myAlert.accept();
	  }
	  catch (NoAlertPresentException e) 
	  {
		fail("accept Alert3 is failed");
	  }
	  
	  WebElement element = driver.findElement(By.id("result"));
	  System.out.println(" "+element.getText());
	  
	  assertEquals(element.getCssValue("color"), "rgba(0, 128, 0, 1)");
	  
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
	  driver.close();
  }

}
