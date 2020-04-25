package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.TestBase;

public class LandingPage extends TestBase {
	//public static WebDriver driver;
	private By Myaccount=By.xpath("//*[text()='my account']");
	
	public WebElement myaccount()
	{
		
		return driver.findElement(Myaccount);
	}
	
	
	
	
	
	

}
