package scripts.po;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class GmailLoginPo extends LoadableComponent<GmailLoginPo>
{
	@FindBy (id = "identifierId")
	@CacheLookup
	private WebElement username;
	
	
	@FindBy (xpath = "//span[text()='Next']")
	@CacheLookup
	private WebElement next;
	
	@FindBy (name = "password")
	private WebElement userpass;
	
	@FindBy (xpath = "//span[text()='Next']")
	private WebElement next2;
	
	
	private WebDriver driver;
	private String expectedTitle = "Gmail";
	
	public GmailLoginPo()
	{
		 System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userid, String password) throws InterruptedException 
	{
		username.sendKeys(userid);	
		next.click();
		userpass.sendKeys(password);
		Thread.sleep(3000);
		next2.click();
	}

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void close()
	{
		driver.quit();
	}
	
	@Override
	protected void load() 
	{
		driver.get("https://mail.google.com/mail/u/0/#inbox");
	}

	@Override
	protected void isLoaded() throws Error 
	{
		assertEquals(driver.getTitle(), expectedTitle);
	}
	
}
