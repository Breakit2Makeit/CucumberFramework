package com.breakit2makeit.cucumberFrameWork;

/*import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSize extends TestBase{
	/*public WebDriver driver;
	public String baseURL;
	protected static final Logger log = LogManager.getLogger(TestBase.class.getName());
	private JavascriptExecutor js;*/

	@BeforeMethod
	public void beforeMethod() {
		/*System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\dbmiadmin\\eclipse-workspace\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseURL = "https://www.breakit2makeit.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;*/

	}

	@Test
	public void testWinSize() throws Exception {
		driver.get(baseURL);
		// size of the window
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");

		System.out.println("Height :" + height);
		System.out.println("Width :" + width);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
