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

public class DataEntry 
{
	WebDriver driver;
	
  @Test
  public void enterData() throws InterruptedException 
  {
	  driver.navigate().to("http://toolsqa.com/automation-practice-form/");
	  driver.findElement(By.name("firstname")).sendKeys("Rahul");
	  driver.findElement(By.name("lastname")).sendKeys("Shedge");
	  String fName = driver.findElement(By.name("firstname")).getAttribute("value");
	  String lName = driver.findElement(By.name("lastname")).getAttribute("value");
	  System.out.println("Entered First name - "+fName);
	  System.out.println("Enterd Last name - "+lName);
	  
	//  String firstText = driver.findElement(By.xpath("//span[text()='Text1']")).getText();
	  Thread.sleep(3000);
	  WebElement ele = driver.findElement(By.id("NextedText"));
	  String secoundText = ele.getText();
	  
	//  System.out.println("First text is "+firstText);
	  System.out.println("Extracted text is "+secoundText);
	  
	  driver.findElement(By.id("sex-0")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("exp-3")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("datepicker")).sendKeys("08 March 2019");
	  
	  System.out.println("Entered Date is -  "+driver.findElement(By.id("datepicker")).getAttribute("value"));
	  
	  WebElement manualTester = driver.findElement(By.id("profession-0"));
	  
	  if(manualTester.isEnabled())
	  {
		  if(!(manualTester.isSelected()))
		  {
			  manualTester.click();
			  Thread.sleep(3000);
		  }
	  }
	  
	  WebElement autTester = driver.findElement(By.id("profession-1"));
	  autTester.click();
	  Thread.sleep(3000);
	  
	  if(autTester.isEnabled())
	  {
		  if(autTester.isSelected())
		  {
			  autTester.click();
			  Thread.sleep(3000);
		  }
	  }
	  
	 driver.findElement(By.id("tool-0")).click();
	 Thread.sleep(3000);
	 
	 driver.findElement(By.id("tool-1")).click();
	 Thread.sleep(3000);
	 
	 driver.findElement(By.id("tool-2")).click();
	 Thread.sleep(3000);
	 
	 Select continents = new Select(driver.findElement(By.id("continents")));
	 
	 System.out.println(" Available continents in dropdown are ");
	 
	 for(WebElement oneContinent : continents.getOptions())
	 {
		 System.out.println(" "+oneContinent.getText());
	 }
	 
	 continents.selectByIndex(2);
	 Thread.sleep(3000);
	 
	 System.out.println("Selected value from Contents dropdown is - "+continents.getFirstSelectedOption().getText());
	 
	 continents.selectByVisibleText("South America");
	 Thread.sleep(3000);
	 
	 WebElement commandsDropdown = driver.findElement(By.id("selenium_commands"));
	 
	 Select commands = new Select(commandsDropdown);
	 
	 System.out.println("Available Selenium Commands in dropdown are - ");
	 
	for(WebElement oneCommand : commands.getOptions())
	{
		System.out.println(" "+oneCommand.getText());
	}
	 
	 commands.selectByVisibleText("Browser Commands");
	 commands.selectByIndex(2);
	 
	 
	 System.out.println("Selected values from Browser commands dropdown are - ");
	 
	 for(WebElement oneElement : commands.getAllSelectedOptions())
	 {
		 System.out.println(" "+oneElement.getText());
	 }
	 
	 driver.findElement(By.id("submit")).click();
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
