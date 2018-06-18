package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	WebDriver driver;
	
	@FindBy(id = "field1")
	WebElement fieldName;
	
	@FindBy(id = "field2")
	WebElement fieldEmail;
	
	@FindBy(id = "field3")
	WebElement fieldSub;
	
	@FindBy(xpath = "//textarea[@name='Message']")
	WebElement fieldMessage;
	
	@FindBy(xpath = "//button[contains(@id, 'submit') and text()='Send']")
	WebElement submitBtn;
	//*[@id="comp-jgzi13v4submit"]
	
	
	public HomePageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void writeName(String name){
		fieldName.sendKeys(name);
	}
	
	public void writeEmail(String email){
		fieldEmail.sendKeys(email);
	}
	
	public void writeSub(String subject){
		fieldSub.sendKeys(subject);
	}
	
	public void writeMessage(String subject){
		fieldMessage.sendKeys(subject);
	}
	
	public void clickSend(){
		submitBtn.click();
	}
}
