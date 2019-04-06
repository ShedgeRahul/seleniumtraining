package ddtExamples;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ddtJXLJarForXLS 
{
	XSSFWorkbook wb = new XSSFWorkbook();
	WebDriver driver;
	
	 @DataProvider (name = "ReadFromXLSX") 
		public Object[][] retObjArr = getDataFromXLSX()
		{
			Object[][] retObjArr = getData("test\\resources\\DataXLSX.xlsx", "Data", "StartAndEnd");
			return (retObjArr);
		}
	
	 @DataProvider (name = "ReadFromXLS")
	  public Object[][] getDataFromXLS() 
	  {
		 Object[][] retObjArr = getTableArray("test\\resources\\login.xls", "LoginData", "StartAndEnd");
	   return (retObjArr); 
	  }

	 @DataProvider (name = "ReadFromCSV") 
		public Iterator getDataFromCSV()
	 {
		      Collection<String[]> retObjArr=null;
			try 
			{
			retObjArr = getTestData("test\\resources\\Datacsv.csv");
			} 
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		        return(retObjArr.iterator());	  

	}
	 

	
	 

@Test(dataProvider = "ReadFromXLS")
  public void loginToNicheThyself(String user, String password) {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();		
  //assertTrue(driver.getTitle().contains("account"));	
  }


  @Test(dataProvider = "ReadFromCSV")
  public void loginToNiche(String user, String password) {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();		
 // assertTrue(driver.getTitle().contains("account"));	
  }

  @Test(dataProvider = "ReadFromXLSX")
  public void login(String user, String password) {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.name("username")).sendKeys(user);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();		
 // assertTrue(driver.getTitle().contains("account"));	
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver-32bit.exe");
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");

	//	driver = new FirefoxDriver();
		driver = new ChromeDriver();
  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }
  
  
  public String[][] getTableArray(String xlsFilePath, String sheetName, String tableName)
  {
	  String[][] tabArray=null;
	  
	  try
	  {
		  Workbook workbook = Workbook.getWorkbook(new File(xlsFilePath));
		  Sheet sheet = workbook.getSheet(sheetName);
		  Cell tableStart = sheet.findCell(tableName);
		  
		  int startRow, startCol, endRow, endCol, ci, cj;
		  
		  startRow = tableStart.getRow();
		  startCol = tableStart.getColumn();
		  
		  
		  Cell tableEnd = sheet.findCell(tableName, startCol+1, startRow+1, 100, 64000, false);
		  
		  endRow = tableEnd.getRow();
		  endCol = tableEnd.getColumn();
		  
		  System.out.println("startRow-"+startRow+" startCol-"+startCol+" endRow-"+endRow+" endCol-"+endCol);
		 
		  tabArray = new String[endRow-startRow-1][endCol-startCol-1];
		  ci=0;
		  for(int i=startRow+1; i<endRow; i++,ci++)
		  { 
		  cj=0;
		  	for(int j=startCol+1; j<endCol; j++,cj++)
		  	{
		  		tabArray[ci][cj] = sheet.getCell(j,i).getContents();
		  	}
		  }
	  }
	  catch (Exception e) {
		
	System.out.println("Please check passed parameters ");
	  }
	  
	  return (tabArray);
	 
  }


  public static Collection<String[]> getTestData(String xlsFilePath) throws IOException
  {
	List<String[]> records = new ArrayList<String[]>();
	  String record;
	  
	  BufferedReader file = new BufferedReader(new FileReader(xlsFilePath));
	  
	  while((record=file.readLine()) != null)
	  {
		  String fields[] = record.split(",");
		  records.add(fields);
	  }
	  file.close();
	  return records;
  }
  
  
  
  public String[][] getData(String filePath, String sheetName, String tagName)
  {
	  String tabArray[][] = null;
	  
	  
	  XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
	  XSSFSheet sheet = workbook.getSheet(sheetName); 
	 Cell tableStart = sheet.
	  
	 
  }


  
 }


    















