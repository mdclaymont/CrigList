package Criglist;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.TestBase;
import PageObject.AccountPage2;
import PageObject.DescriptionPage;
import PageObject.LandingPage;
import PageObject.LogInPage;

public class DeletPost extends TestBase{
	public static LandingPage lp=new LandingPage();
	public static LogInPage lip=new LogInPage();
	public static AccountPage2 ac=new AccountPage2();
	public static DescriptionPage dp=new DescriptionPage();
	public static Object[][]	PostData;
	
	@BeforeTest
	public void commonAll() throws IOException
	{
		getData();
		TestBase.initilizeDriver();
		openUrl("");
		validateUrl();
		lp.myaccount().click();
		lip.Inputid().sendKeys("iphonepnt@gmail.com");
		lip.InputPassword().sendKeys("Tester@7453");
		lip.LogInButton().click();
	}
	@Test()
	public void Delete() throws InterruptedException, IOException
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
	@AfterTest
	public void closeBrowser()
	{
		closeBrowser("");
		driver=null;
	}
	
	
}
