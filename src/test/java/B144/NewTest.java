package B144;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.store.Public2;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Ignore;
import org.junit.experimental.categories.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.interactions.KeyInput;

import net.bytebuddy.asm.Advice.AllArguments;

public class NewTest {
	static WebDriver driver;
	//static reportFanction t3 = new reportFanction(driver);
	//static ExtentReports extent;
	//static ExtentTest test;
	
	@BeforeClass
		public void  open_brows() {
		String url = "https://www.b144.co.il";
		//url="https://www.b144.co.il/b144_sip/4A1404134470655D4C1401144272615D4E.aspx?reqCity=3000";
		Testing.beforeClass(url);
	//	extent = reportFanction.GetExtent();
		//test = t3.createTest("test1", "description");
	}
        
	/*	@Test (priority = 0)//כניסת מנויים
		public void member() throws InterruptedException, IOException, AWTException{
			Testing.member();
			}*/
		

		
	/*	@Test(priority = 1)//רישום עצמי
		public void selfRegister()throws InterruptedException, IOException, AWTException{
		Testing.sing_alon();
		}
	
	*//*
	@Test(priority = 2)//חיפוש עסקים
	public void search_Business() throws InterruptedException, IOException, AWTException{
		Testing.search_Business();
	}
	
	@Test(priority = 3)//השארת תגובה
	public void rateBusiness()  throws InterruptedException, IOException, AWTException{
		Testing.rateBusiness();
	}
	@Test(priority = 4)//קופונים
	public void kopon_world() throws InterruptedException, IOException, AWTException {
		Testing.kopon_world();
	}
	@Test(priority = 5)//חיפוש אנשים
	public void search_people() throws InterruptedException, IOException, AWTException {
		Testing.search_people();
	}
	@Test(priority = 6)//מפות
	public void maps() throws InterruptedException, IOException, AWTException {
		Testing.maps();
	}/*
	@Test(priority = 7)//מי פנוי
	public void MiPanoey() throws InterruptedException, IOException, AWTException {
		Testing.MiPanoey();
	}
	*/
	@Test (priority = 7)
	public void fullSelf_ragistr() throws InterruptedException, IOException, AWTException {
		//Categories_H1.excel();
		Testing.ww();
		//Categories_H1.hh(driver);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
	
	  Testing.afterClass();
}

}
