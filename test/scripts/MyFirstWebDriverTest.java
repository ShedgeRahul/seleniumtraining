package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWebDriverTest 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver-32bit.exe");
	//	driver = new FirefoxDriver();
		
		//driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com/");
		
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();

		String expectedTitle = "My account";
		String actualTitle = driver.getTitle();
		
		
		if (expectedTitle.equals(actualTitle))
			System.out.println("Login Testcase is Passed");
		else 
			System.out.println("Login Testcase is Failed");
	
	driver.quit();
	}

}
