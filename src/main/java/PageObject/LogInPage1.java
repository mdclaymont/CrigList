package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.TestBase;

public class LogInPage1 extends TestBase {
	
	
	public LogInPage1()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#inputEmailHandle") WebElement inputid ;
	@FindBy(xpath="//*[@name='inputPassword']" ) WebElement UiPassword  ;
	@FindBy(xpath= "//*[@id='login']") WebElement login   ;
	
	/****************************************************************************************************/	
	public WebElement Inputid()
		{
			return inputid;
		}
	/****************************************************************************************************/	
	public WebElement InputPassword()
	
		{
			return UiPassword;
		}
	/****************************************************************************************************/	
    public WebElement LogInButton()
	
		{
			return login;
		}
    /**
     * @return **************************************************************************************************/	
    public DescriptionPage LogIn(String UId,String UPassword)
    {
    	inputid.sendKeys(UId);
    	UiPassword.sendKeys(UPassword);
       	login.click();
    	return new DescriptionPage(); 
    	
    }
	
	
}
