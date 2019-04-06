package scripts.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGConfig3 {
	 @Test
	  public void test1() {
	  System.out.println("Inside test1 of TestNGConfig3");
	  }
	  
	  @Test
	  public void test2() {
		  System.out.println("Inside test2 of TestNGConfig3");
	  }
	  
	  @Test
	  public void test3() {
		  System.out.println("Inside test3 of TestNGConfig3"); 
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Inside beforeMethod of TestNGConfig3");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Inside afterMethod of TestNGConfig3");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside beforeClass of TestNGConfig3");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside afterClass of TestNGConfig3");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Inside beforetest of TestNGConfig3");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Inside aftertest of TestNGConfig3");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Inside beforeSuite of TestNGConfig3");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Inside aftersuite of TestNGConfig3");
	  }

	}
