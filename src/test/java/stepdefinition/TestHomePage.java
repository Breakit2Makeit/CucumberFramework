package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.breakit2makeit.cucumberFrameWork.GenericMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import page.classes.HomePageFactory;

public class TestHomePage {
	static WebDriver driver;
	public JavascriptExecutor js;
	protected GenericMethods gm;
	HomePageFactory homePage;
	
	@BeforeMethod
	public void beforeMethod() {
		js = (JavascriptExecutor) driver;
		gm = new GenericMethods(driver);
		homePage = new HomePageFactory(driver);
		
	}
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dbmiadmin\\eclipse-workspace\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "https://www.breakit2makeit.org/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		Thread.sleep(2000);
	}

	@Given("scroll down to the message box")
	public void scroll_down_to_the_message_box() throws InterruptedException {
		js.executeScript("window.scrollBy(0, 2700);");
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='Message']")));
	}

	@When("user enter name")
	public void user_enter_name() throws InterruptedException {
		homePage.writeName("Johnson");
		Thread.sleep(2000);
	}

	@When("enter email id")
	public void enter_email_id() throws InterruptedException {
		homePage.writeEmail("John@john.com");
		Thread.sleep(2000);
	}

	@When("enter subject")
	public void enter_subject() throws InterruptedException {
		homePage.writeSub("First subscription");
		Thread.sleep(2000);
	}

	@When("enter message")
	public void enter_message() throws Exception {
		WebElement element = gm.getXpathElements("//textarea[@name='Message']", "textarea");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		homePage.writeMessage("Message Message Message Message Message Message Message ");
		Thread.sleep(2000);
	}

	@When("click on send")
	public void click_on_send() {
		homePage.clickSend();
	    throw new PendingException();
	}

	@Then("User getsa a confirmaton message")
	public void user_getsa_a_confirmaton_message() {
	    String message = driver.getPageSource();
	    System.out.println(message);
	}

	@When("user enter no name")
	public void user_enter_no_name() throws Exception {
		homePage.writeName("");
		Thread.sleep(2000);
	}

	@When("enter no email id")
	public void enter_no_email_id() throws Exception {
		homePage.writeEmail("");
		Thread.sleep(2000);
	}

	@When("enter no subject")
	public void enter_no_subject() throws Exception {
		homePage.writeSub("First subscription");
		Thread.sleep(2000);
	}

	@When("click on invalid send")
	public void click_on_invalid_send() {
		homePage.clickSend();
	    throw new PendingException();
	}

	@Then("User gets a warning message")
	public void user_gets_a_warning_message(DataTable dataTable) {
		String message = driver.getPageSource();
	    System.out.println(message);
		
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new PendingException();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Quit Browser");
		driver.quit();
	}
	
}
