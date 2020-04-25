package Criglist;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.TestBase;
import PageObject.AccountPage2;
import PageObject.DescriptionPage;
import PageObject.LandingPage;
import PageObject.LogInPage;

public class PostIphone extends TestBase{
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
		setSelect(ac.newpost()).selectByValue("dlw");
		ac.Go().click();
		ac.SellBy().click();
		ac.SellCatagory().click();
	}
	@Test()
	public void details() throws InterruptedException, IOException
	{
		Object[][] PostData=getExcelData("Crig", "C:\\Users\\nyc\\git\\repository\\MavenCrig\\src\\main\\java\\Data\\Controller.xlsx","tcflag,yes");
		
		dp.postingTitle().sendKeys(PostData[0][0].toString());
		dp.price().sendKeys(PostData[0][1].toString());
		dp.postalCode().sendKeys(PostData[0][2].toString());
		dp.description().sendKeys(PostData[0][3].toString());
		Thread.sleep(1000);
		dp.setOs(PostData[0][4].toString());
		dp.showPhone().click();
		dp.phoneNumber().sendKeys(PostData[0][5].toString());
		dp.continueClick().click();
		dp.continueClick().click();
		dp.addImage().click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("F:\\Software Testing\\Selenium\\AutoIt\\MultiFile.exe" + " " + "F:\\SellPicture\\Iphone7Plus\\B1.JPG");
		Thread.sleep(6000);
		dp.addImage().click();
		Runtime.getRuntime().exec("F:\\Software Testing\\Selenium\\AutoIt\\MultiFile.exe" + " " + "F:\\SellPicture\\Iphone7Plus\\B2.JPG");
		Thread.sleep(3000);
		dp.doneImage().click();
		dp.publish().click();
	}

	
	
	@AfterTest
	public void closeBrowser()
	{
		closeBrowser("");
		driver=null;
	}
	
	
}
