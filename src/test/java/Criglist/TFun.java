package Criglist;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.interactions.Actions;
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

public class TFun extends TestBase{
	public static LandingPage lp=new LandingPage();
	public static LogInPage lip=new LogInPage();
	public static AccountPage2 ac=new AccountPage2();
	public static DescriptionPage dp=new DescriptionPage();
	public static Object[][]	PostData;
	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
		
		
		
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
	
}
