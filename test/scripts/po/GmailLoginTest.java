package scripts.po;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import javax.swing.plaf.synth.SynthStyle;

import org.testng.annotations.AfterMethod;

public class GmailLoginTest 
{
	GmailLoginPo myLogin;
	
  @Test
  public void gmailLoginTest() throws InterruptedException
  {
	myLogin.login("rshedge07", "cologate");
	Thread.sleep(3000);
//	assertEquals(myLogin.getTitle().contains("Inbox"));
	System.out.println(" "+myLogin.getTitle());
	if(myLogin.getTitle().toLowerCase().startsWith("inbox"))
	{
		System.out.println("Pass ");
	}
	  System.out.println("Fail");
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  myLogin = new GmailLoginPo();
	  myLogin.get();
  }

 @AfterMethod
  public void afterMethod() 
  {
	  myLogin.close();
  }

}
