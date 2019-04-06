package webelementsassignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class SendGmail {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void sendGmail() throws InterruptedException 
  {
	  driver.get("https://mail.google.com/mail/u/0/#inbox");
	  driver.findElement(By.id("identifierId")).sendKeys("");
	  driver.findElement(By.xpath("//span[@class='RveJvd snByac'][text()='Next']")).click();
	  WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	  password.sendKeys("");
	  // driver.findElement(By.name("password")).sendKeys("");
	  WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='RveJvd snByac'][text()='Next']")));
	  next.click();
	  //driver.findElement(By.xpath("//span[@class='RveJvd snByac'][text()='Next']")).click();
	  WebElement compose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Compose']")));
	  compose.click();
	 // driver.findElement(By.xpath("//div[text()='Compose']")).click();
	 WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
	 to.sendKeys("rshedge07@gmail.com");
	 // driver.findElement(By.name("to")).sendKeys("rshedge07@gmail.com");
	  driver.findElement(By.name("subjectbox")).sendKeys("Email sent by automation script");	
	  driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("I have sent an email using Gmail account");
	  driver.findElement(By.xpath("//div[text()='Send']")).click();	  
	  
	  WebElement profileImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_ya gbii']")));
	  profileImage.click();
	 
	  WebElement logOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']")));
	  logOut.click();
  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 20);
  }

 @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
