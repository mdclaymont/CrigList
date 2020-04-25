package Criglist;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.TestBase;
import PageObject.AccountPage;
import PageObject.DescriptionPage;
import PageObject.LandingPage;
import PageObject.LogInPage;

public class DeletPostByFind extends TestBase{
	public DeletPostByFind()
	{
		super();
	}
	public static LandingPage lp;
	public static LogInPage lip;
	public static AccountPage ac;
	public static DescriptionPage dp;
	public static Object[][]	PostData;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		
		
		getData();
		initilizeDriver();
		openUrl("");
		validateUrl();
		lp=new LandingPage();
		lip=new LogInPage();
		ac=new AccountPage();
		dp=new DescriptionPage();
		lp.myaccount().click();
		lip.Inputid().sendKeys("iphonepnt@gmail.com");
		lip.InputPassword().sendKeys("Tester@7453");
		System.out.println(lip.Inputid().getText());
		lip.LogInButton().click();
	}
	
	@Test
	public void DeletePostTest() throws InterruptedException, IOException
	{
		int totalrow=ac.postDateCol().size();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
	    Date date = new Date(); 
	    String  todayDate=formatter.format(date);
	   	for(int i=0;i<totalrow;i++)
		{
			String postValue=ac.postDateCol().get(i).getText();
		
			if(!postValue.contains(todayDate))
			{
				String status=ac.Status().get(i).getText();
					if(status.toLowerCase().contains("active"))
					{
						ac.delete().get(i).click();
						driver.navigate().back();
						Thread.sleep(7000);
						System.out.println(postValue);
					}
			}
			
		}
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		closeBrowser("");
		driver=null;
	}
	
	
}
