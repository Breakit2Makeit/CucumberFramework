package com.breakit2makeit.cucumberFrameWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
		  driver = new FirefoxDriver();
		  baseURL = "https://www.breakit2makeit.org/";
		  
	  }
	
  @Test
  public void testBase() {
	  
	  driver.get(baseURL);
  }


  @AfterMethod
  public void afterMethod() {
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
