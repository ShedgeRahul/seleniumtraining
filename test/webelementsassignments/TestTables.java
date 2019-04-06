package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import webelementsassignments.*;

public class TestTables {
	WebDriver driver;
	WebDriverWait wait;
	@Test
  public void testTable() 
	{
	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tsc_table_s13")));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("table1")));	 
	WebTable table = new WebTable(element);
	List <WebElement> allRows = table.getAllDataRows();
	System.out.println("Table row size is -  "+allRows.size());
	
	List<WebElement> allColumns = table.getAllDataColumns();
	System.out.println("Table column size is - "+allColumns.size());
	for(WebElement oneColumn: allColumns)
	{
		System.out.println(" "+oneColumn.getText());
	}
	
	table.deleteRow("Email", "jdoe");
	String expectedUrl = "http://the-internet.herokuapp.com/tables#delete";
	assertEquals(driver.getCurrentUrl(), expectedUrl);
/*
	table.deleteRow("Mecca");
	String expectedUrl = "https://www.toolsqa.com/automation-practice-table#";
	assertEquals(driver.getCurrentUrl(), expectedUrl);
*/
	}
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 
	//  driver.get("https://www.toolsqa.com/automation-practice-table");
	   driver.get("http://the-internet.herokuapp.com/tables");
	 wait = new WebDriverWait(driver, 20);
  }

// @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
