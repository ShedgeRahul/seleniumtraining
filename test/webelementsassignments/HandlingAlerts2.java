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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class HandlingAlerts2 {
WebDriver driver;

	@Test
  public void alert2() 
	{
	driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	driver.findElement(By.id("simple")).click();
	Alert myAlert;
	try
	{
		myAlert = driver.switchTo().alert();
		System.out.println(" "+myAlert.getText());
		myAlert.accept();
	}
	catch (NoAlertPresentException e) 
	{
	fail(" First Alert is failed ");	
	}
	
	driver.findElement(By.id("confirm")).click();
	try
	{
		myAlert = driver.switchTo().alert();
		myAlert.dismiss();
	}
	catch (NoAlertPresentException e) 
	{
	fail("Dismiss Aler2 failed");	
	}
	
	String text1 = driver.findElement(By.xpath("//p[text()='You Dismissed Alert!']")).getText();
	System.out.println(" "+text1);
	assertEquals(text1, "You Dismissed Alert!");
	
	driver.findElement(By.id("confirm")).click();
	try
	{
		myAlert = driver.switchTo().alert();
		System.out.println(" "+myAlert.getText());
		myAlert.accept();
	}
	catch (NoAlertPresentException e) 
	{
	fail("Accept Alert2 failed ");
	}
	
	String text2 = driver.findElement(By.xpath("//p[text()=\"You Accepted Alert!\"]")).getText();
	System.out.println(" "+text2);
	assertEquals(text2,"You Accepted Alert!");
		
	driver.findElement(By.id("prompt")).click();
	try {
		myAlert = driver.switchTo().alert();
		myAlert.dismiss();
		System.out.println("Alert3 is Dismissed ");
		}
	catch (NoAlertPresentException e) 
	{
		fail("Dismiss Alert3 is failed ");
	}
	
	driver.findElement(By.id("prompt")).click();
	try 
	{
	myAlert = driver.switchTo().alert();
	System.out.println(" "+myAlert.getText());
	myAlert.sendKeys("Rahul Shedge");
	myAlert.accept();
	} 
	catch (NoAlertPresentException e) 
	{
		fail("Accept Alert3 is failed");	
	}
	
	String text3 = driver.findElement(By.xpath("//p[@id='prompt_demo']")).getText();
	System.out.println(" "+text3);
	assertEquals(text3,"Hello Rahul Shedge! How are you today?");
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
