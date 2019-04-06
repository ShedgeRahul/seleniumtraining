package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Dropdown 
{
	WebDriver driver;
	
  @Test
  public void selectDropdownValues() 
  {
	  driver.get("http://the-internet.herokuapp.com/dropdown");
	  WebElement dropdown = driver.findElement(By.id("dropdown"));
	  Select dropdownValues = new Select(dropdown);
	  
	dropdownValues.selectByIndex(2);
	
//	String selectedOption = dropdownValues.getFirstSelectedOption().getText();
	  System.out.println("Selected option is  "+dropdownValues.getFirstSelectedOption().getText());
	  
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
