package com.breakit2makeit.cucumberFrameWork;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Author Johns K Paul for Breakit2Makeit
 * This is the first Test file to be created after the set up
 * This file will have the base urls and log in info as required
 * All other files will extend to this
*/

public class TestBase {
	protected WebDriver driver;
	protected String baseURL;
	protected static final Logger log = LogManager.getLogger(TestBase.class.getName());
	
	  @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Apache\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  baseURL = "https://www.breakit2makeit.org/";
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	  }
	
  @Test
  public void testBase() throws Exception {
	  
	  driver.get(baseURL);
	  driver.findElement(By.xpath("//div[@name='Message']//textarea")).sendKeys("Test");

	  
  }


  @AfterMethod
  public void afterMethod() {
//	  driver.quit();
  }

  /*@BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }*/

}
