package com.breakit2makeit.cucumberFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptRepos {
	WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptRepos(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public WebElement scroll2view(String locator, String winsize) {
		
		js.executeScript(winsize);
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return null;
		}
		
	
}


//public WebDriver getDriver() {
//	return driver;
//}