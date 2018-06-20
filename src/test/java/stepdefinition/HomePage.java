package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.breakit2makeit.cucumberFrameWork.GenericMethods;
import com.breakit2makeit.cucumberFrameWork.TestBase;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import page.classes.HomePageFactory;

/*
 * Author Johns K Paul for Breakit2Makeit
 * This is the first Test file to be created after the set up
 * This file will have the base urls and log in info as required
 * All other files will extend to this
*/

public class HomePage extends TestBase {
	protected WebDriver driver;
	protected String baseURL;
	protected static final Logger log = LogManager.getLogger(HomePage.class.getName());
	protected JavascriptExecutor js;
	protected GenericMethods gm;
	HomePageFactory homePage;

	@BeforeMethod
	public void beforeMethod() {
		js = (JavascriptExecutor) driver;
		gm = new GenericMethods(driver);
		homePage = new HomePageFactory(driver);

	}

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		driver.get(baseURL);
		throw new PendingException();
	}

	@Given("scroll down to the message box")
	public void scroll_down_to_the_message_box() {
		js.executeScript("window.scrollBy(0, 2700);");
		WebElement element = gm.getXpathElements("//textarea[@name='Message']", "textarea");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='Message']")));
		throw new PendingException();
	}

	@When("user enter name")
	public void user_enter_name() {
		homePage.writeName("Johnson");
		throw new PendingException();
	}

	@When("enter email id")
	public void enter_email_id() {
		homePage.writeEmail("John@john.com");
		throw new PendingException();
	}

	@When("enter subject")
	public void enter_subject() {
		homePage.writeSub("First subscription");
		throw new PendingException();
	}

	@When("enter message")
	public void enter_message() {
		homePage.writeMessage("Message Message Message Message Message Message Message ");
		throw new PendingException();
	}

	@When("click on send")
	public void click_on_send() {
		// homePage.clickSend();
		throw new PendingException();
	}

	@Then("User getsa a confirmaton message")
	public void user_getsa_a_confirmaton_message() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
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
