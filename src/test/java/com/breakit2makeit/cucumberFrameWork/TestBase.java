package com.breakit2makeit.cucumberFrameWork;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.breakit2makeit.cucumberFrameWork.GenericMethods;

import page.classes.HomePageFactory;

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
	protected JavascriptExecutor js;
	protected GenericMethods gm;
	HomePageFactory homePage;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Apache\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL = "https://www.breakit2makeit.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		gm = new GenericMethods(driver);
		homePage = new HomePageFactory(driver);

	}

	@Test
	public void testBase() throws Exception {
		driver.get(baseURL);

		// Scroll down

		js.executeScript("window.scrollBy(0, 2700);");
		// Explicit wait

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='Message']")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field1']")));

		homePage.writeName("Johnson");
		Thread.sleep(2000);
		homePage.writeEmail("John@john.com");
		Thread.sleep(2000);
		homePage.writeSub("First subscription");
		Thread.sleep(2000);

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='Message']")));

		// Scroll Element into view
		WebElement element = gm.getXpathElements("//textarea[@name='Message']", "textarea");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		homePage.writeMessage("Message Message Message Message Message Message Message ");
		Thread.sleep(2000);
		homePage.clickSend();

//		gm.getXpathElements("//textarea[@name='Message']", "textarea").sendKeys("Message: kjlkhjlkjkjikj");

		// driver.findElement(By.xpath("//textarea[@name='Message']")).sendKeys("Message:
		// kjlkhjlkjkjikj");
		Thread.sleep(20000);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Quit Browser");
		driver.quit();
	}

	/*
	 * @BeforeClass public void beforeClass() { }
	 * 
	 * @AfterClass public void afterClass() { }
	 * 
	 * @BeforeTest public void beforeTest() { }
	 * 
	 * @AfterTest public void afterTest() { }
	 * 
	 * @BeforeSuite public void beforeSuite() { }
	 * 
	 * @AfterSuite public void afterSuite() { }
	 */

}
