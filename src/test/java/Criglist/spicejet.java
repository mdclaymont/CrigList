package Criglist;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Common.TestBase;
import Common.TestUtility;

public class spicejet extends TestBase{

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
       
		getData();
		
	//	Object[][]	PostData=getExcelData("Crig", "C:\\Users\\nyc\\MavenCrig\\src\\main\\java\\Data\\Controller.xlsx","tcflag,yes");
		//String Crig=PostData.toString();
		TestBase.initilizeDriver();
		openUrl("https://www.spicejet.com/");
		validateUrl();
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).sendKeys("aj");
		Thread.sleep(5000);
		List<WebElement> obje=driver.findElements(By.xpath("//*[@class='dropdownDiv']/ul//li"));
		int totallist=obje.size();
		for(int i=0;i<totallist;i++)
		{
			String Actual=obje.get(i).getText();
			if(Actual.toLowerCase().contains("Ajmer (KQH)".toLowerCase()))
			{
				obje.get(i).click();
				break;
			}
		}
		
		closeBrowser("");	
	}

}
