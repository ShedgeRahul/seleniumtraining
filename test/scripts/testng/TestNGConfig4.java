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

public class TestNGConfig4 {
	 @Test
	  public void test1() {
	  System.out.println("Inside test1 of TestNGConfig4");
	  }
	  
	  @Test
	  public void test2() {
		  System.out.println("Inside test2 of TestNGConfig4");
	  }
	  
	  @Test
	  public void test3() {
		  System.out.println("Inside test3 of TestNGConfig4"); 
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Inside beforeMethod of TestNGConfig4");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Inside afterMethod of TestNGConfig4");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside beforeClass of TestNGConfig4");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside afterClass of TestNGConfig4");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Inside beforetest of TestNGConfig4");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Inside aftertest of TestNGConfig4");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Inside beforeSuite of TestNGConfig4");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Inside aftersuite of TestNGConfig4");
	  }

	}
