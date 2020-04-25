package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.TestBase;

public class LogInPage extends TestBase {
	private By inputid=By.cssSelector("#inputEmailHandle");
	private By UiPassword=By.xpath("//*[@name='inputPassword']");
	private By login =By.xpath("//*[@id='login']");
	
	
	/****************************************************************************************************/	
	public WebElement Inputid()
	{
		return driver.findElement(inputid);
	}
	/****************************************************************************************************/	
	public WebElement InputPassword()
	
	{
		return driver.findElement(UiPassword);
	}
	/****************************************************************************************************/	
    public WebElement LogInButton()
	
	{
		return driver.findElement(login);
	}
	
}
