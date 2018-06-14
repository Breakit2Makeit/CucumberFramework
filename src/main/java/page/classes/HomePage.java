package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element = null;

	public static WebElement readMoreButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[text()='READ MORE']"));
		return element;
	}

	public static WebElement enterName(WebDriver driver) {
		element = driver.findElement(By.id("field1"));
		return element;
	}
	
	public static WebElement enterEmail(WebDriver driver) {
		element = driver.findElement(By.id("field2"));
		return element;
	}
	
	public static WebElement enterSub(WebDriver driver) {
		element = driver.findElement(By.id("field3"));
		return element;
	}
	
	public static WebElement textMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//textarea[name()='Message']"));
		return element;
	}
	
//	Click on read more button
	public static void clickOnReadMore(WebDriver driver){
		element = readMoreButton(driver);
		element.click();
		
	}
}