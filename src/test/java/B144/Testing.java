package B144;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Get;
import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.ss.formula.functions.Index;
import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.ScreenCapture;

import freemarker.ext.beans.MapModel;

public class Testing {
	
	static  public WebDriver driver ;
	
	static reportFanction t3 = new reportFanction(driver);
	static ExtentReports extent;
	static ExtentTest test;
	
	
	String drivepeth ="C:\\java niso\\maven_tirgol\\src\\test\\testNG.xml";
	static elements pom=new elements();
	
	
	  public static void beforeClass(String url) {
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\segal\\Downloads\\chromedriver_win325//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		//driver.get("https://www.b144.co.il/b144_sip/4A1404134470655D4C16031B4779655F4D.aspx?reqCity=627");
		driver.manage().window().maximize();
		extent =t3.GetExtent();
		test = t3.createTest("senty test", "dayli test");
		elements pom1 =PageFactory.initElements(driver ,elements.class);
	//******************************************׳¨׳™׳©׳•׳� ׳¢׳¦׳�׳™*************************************************	
		
	}
	public static void sing_alon() throws InterruptedException, IOException, AWTException {
		
		//"level 1"
		
		elements.selfRegisterLink(driver);
		Thread.sleep(1000);
		driver.findElement(By.id("input_contactName")).sendKeys("בדיקה בדיקה");
		driver.findElement(By.id("input_contactName")).sendKeys(Keys.TAB);
        driver.findElement(By.id("input_businessNameStepOne")).sendKeys(" בדיקה  בדיקה");
        driver.findElement(By.id("input_businessNameStepOne")).sendKeys(Keys.TAB);
        driver.findElement(By.id("input_contactPhone")).sendKeys("0502011359");
        driver.findElement(By.id("input_contactPhone")).sendKeys(Keys.TAB);
		driver.findElement(By.id("input_contactEmail")).sendKeys("bdiki@bdiki.com");
		String busnnes_level1= driver.findElement(By.id("input_businessNameStepOne")).getText();
		boolean isselct;
		isselct =driver.findElement(By.id("agreeToTermsLevel1")).isSelected();
		if (isselct==true) {driver.findElement(By.id("btn_form")).click();}
		else {driver.findElement(By.id("agreeToTermsLevel1")).click();}
		
		//pop up 
		 driver.switchTo().frame(2);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 String sendmeKode= driver.findElement(By.id("popUpNotificationTitle")).getText();
		 if (sendmeKode.equals("׳©׳�׳™׳—׳× ׳§׳•׳“ ׳�׳™׳�׳•׳×")) {test.pass("level 1 pass");
			}
		 else {test.fail("level 1 fail",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());}
		 
		// assertEquals(sendmeKode,"׳©׳�׳™׳—׳× ׳§׳•׳“ ׳�׳™׳�׳•׳×");
		 driver.findElement(By.id("popUpNotificationButton")).click();
		 Thread.sleep(1500);
		driver.findElement(By.id("notificationWithInputAndCaptcha_input")).sendKeys("55555");
		driver.findElement(By.id("notificationWithInputAndCaptcha_sendCode")).click();
		Thread.sleep(500);
		//****************************************׳¨׳™׳©׳•׳� ׳¢׳¦׳�׳™ ׳©׳�׳‘ 2****************************
		//level 2
		
		 String business_level2= driver.findElement(By.id("input_businessName")).getText();
		if (business_level2.contains(busnnes_level1)){test.pass("same business name");
			
		} else {test.fail("not the same business name",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			
		} 
		//׳₪׳�׳�׳₪׳•׳�
		pom.selfRegister_phone_level2(driver).sendKeys("0502011359");
		
		
		//׳¢׳™׳¨				
		pom.selfRegister_city_level2(driver).sendKeys("נת");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Random random=new Random();
		elements.cityList_level2(driver).get(random.nextInt(elements.cityList_level2(driver).size())).click();
		
			
		
		//׳¨׳—׳•׳‘
		pom.selfRegister_street_level2(driver).sendKeys("נת");
		elements.StreetList_level2(driver).get(random.nextInt(elements.StreetList_level2(driver).size())).click();
	
	
	//׳×׳�׳•׳¨ ׳”׳¢׳¡׳§ 
	for (int i=0;i<85;i++) {driver.findElement(By.id("input_businessDescription")).sendKeys("1");}
	//׳§׳˜׳’׳•׳¨׳™׳”
	driver.findElement(By.id("input_businessCategory")).sendKeys("הובלות");
	//׳©׳�׳—
	driver.findElement(By.id("btn_form")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 String thank_you_self=driver.findElement(By.xpath("//*[@class=\"thank_header_dv\"]")).getText();
	if (thank_you_self.contains("׳×׳•׳“׳” ׳©׳‘׳—׳¨׳× ׳�׳”׳¦׳˜׳¨׳£ ׳�׳�׳�׳•׳× ׳�׳�׳₪׳™")) {test.pass("self Register sent");	
	}
	else {test.fail("self Register did not sent",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());

	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(1000);
	elements.B144logo(driver);
		
	
	}
			
		
	//*******************************************׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�**********************************************
		
	
	public static void member() throws InterruptedException, IOException, AWTException{
		test.pass("׳¢׳‘׳¨׳™׳×");
		
		/*
		elements.hamborger_Button(driver);
		elements.hamborger_search(driver).get(2).click();
		elements.hamborger_insaidMenu(driver).get(10).click();
		Thread.sleep(1000);
	String members= driver.findElement(By.xpath("//div[@class=\"dv-connect-header\"]")).getText();
	
	//********׳‘׳“׳™׳§׳× ׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳� **************88
	
	if (members.equals("׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�")) {
		test.pass("׳”׳’׳¢׳” ׳�׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�");
		test.pass("׳”׳¦׳�׳™׳— ׳�׳”׳’׳™׳¢ ׳�׳“׳£ ׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
	} else {
		test.fail("׳”׳’׳¢׳” ׳�׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�");
	}
	
			Assert.assertEquals(members, "׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�");	
			
			try {driver.findElement(By.id("txtUserName")).sendKeys("023332556");
			driver.findElement(By.id("txtUserName")).sendKeys(Keys.TAB);
			driver.findElement(By.id("txtPassword")).sendKeys("123qwe");
			driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			String member_name=driver.findElement(By.id("Navigation_UserName")).getText();
			if (member_name.equals("׳“׳ ׳™׳�׳�")) {	
				test.pass("׳ ׳›׳ ׳¡ ׳�׳�׳ ׳•׳™");
			}
			else {test.fail("׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳� ",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());}
			
			driver.findElement(By.xpath("//div[@class=\"user_options\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("׳”׳×׳ ׳×׳§")).click();
			Thread.sleep(1000);
			Assert.assertEquals(members, "׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class=\"desktop-b144-logo\"]")).click();
			} catch (Exception e) {test.fail("׳�׳� ׳™׳¦׳� ׳�׳›׳ ׳™׳¡׳× ׳�׳ ׳•׳™׳™׳�",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			
			}
			*/
			}
	//********************************************׳—׳™׳₪׳© ׳¢׳¡׳§׳™׳�**************************************************
	
	public static void search_Business() throws InterruptedException, IOException, AWTException{
		Thread.sleep(1000);
		pom.search_Business_bar(driver).sendKeys("׳¦׳�");
		Thread.sleep(1500);
		List<WebElement>search_BusinessliList=driver.findElements(By.xpath("/html/body/ul[1]/li"));
		Thread.sleep(500);
		search_BusinessliList.get(0).click();
		
		//׳›׳₪׳×׳•׳¨ ׳—׳™׳₪׳•׳©
		elements.search_button(driver);
		//׳”׳›׳•׳×׳¨׳×
		String H1= elements.H1(driver);
		//assertEquals (H1, "׳¦׳�׳™׳’׳™׳�") ;
		if (H1.equals("׳¦׳�׳™׳’׳™׳�")) {	
			test.pass("H1 and the search are equals");
		}
		else {test.fail("H1 and the search are not equals ",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());}
		
		driver.findElement(By.xpath("//*[@class=\"filter-inner-container\"]/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@class=\"drop-box-content filter-inner-container\"]/div[2]/a[2]")).click();
		
		//׳�׳¡׳₪׳¨׳™׳� ׳—׳©׳•׳₪׳™׳�
	int num_display =elements.display_number(driver);
		if (num_display==3) {	test.pass("there are 3 phones are display ");
		}
		else {test.fail(" there are less then 3 phones are display",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
		}
		
		//׳�׳¡׳₪׳¨׳™׳� ׳�׳� ׳—׳©׳•׳₪׳™׳�
		int diplay_bis_numbers=elements.numbers_dont_display(driver);
		if (diplay_bis_numbers==12) {test.pass("there are 12 phones are display ");
		}
		else {test.fail(" there are less then 3 phones are display",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
		}
		
		for (int i=0; i<2; i++) {
		driver.findElement(By.id("showNumber4_cardPlace")).click();}
		Thread.sleep(5000);
		// ׳¢׳•׳“ ׳�׳₪׳©׳¨׳•׳™׳•׳×
		elements.more_options(driver);
		
		//׳‘׳—׳™׳¨׳× ׳¢׳¡׳§
		elements.bissList(driver);
		driver.navigate().back();
		
		//׳—׳™׳₪׳•׳©׳™׳� ׳”׳•׳‘׳�׳•׳× ׳’׳�׳’׳�׳™׳”
		pom.search_Business_bar(driver).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pom.search_Business_bar(driver).sendKeys("׳”׳•׳‘׳�׳•׳×");
		Thread.sleep(500);
		pom.search_city_bar(driver).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pom.search_city_bar(driver).sendKeys("׳’׳�׳’");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(1500);
		List<WebElement>list_search_city=driver.findElements(By.xpath("/html/body/ul[1]/li[*]"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		list_search_city.get(0).click();
		
		driver.findElement(By.id("goToMember1")).click();
		//׳ ׳•׳×׳� ׳©׳™׳¨׳•׳× ׳�׳™׳“ ׳”׳�׳₪׳”
		String service_locationString =elements.service_location(driver);
		if (service_locationString != null  ) {test.pass("service location are display ");
			}
		else {
			test.fail(" service location are not display",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
		}
		//׳�׳–׳•׳¨ ׳©׳™׳¨׳•׳× ׳�׳�׳˜׳”	
		if (pom.service_location_butt(driver)!= null) {test.pass("service location button are display ");
			}
		else {test.fail(" service location button are not display",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			
		}
		
	}
	//********************************׳“׳™׳¨׳•׳’ ׳¢׳¡׳§********************************************************
	
	public  static void rateBusiness()throws InterruptedException, IOException, AWTException{
		driver.findElement(By.xpath("//*[@class=\"bcard-inner-header rateBusiness-header\"]")).click();
		
		
		
		 driver.findElement(By.id("com_body")).sendKeys("׳‘׳“׳™׳§׳”");

			 List<WebElement>rateBusiness_list=driver.findElements(By.xpath("//*[@id=\"insertRatingContainer\"]/div/div/i"));
			 for(int i=0;i<rateBusiness_list.size();i++) {rateBusiness_list.get(i).click();}
		
		/*/ driver.findElement(By.xpath("//*[@id=\"insertRatingContainer\"]/div/div/i")).click();
		driver.findElement(By.id("btnCommentUploadFile")).click();
		Robot robot=new Robot();
		robot.mouseMove(40,220);
		robot.delay(500);
		elements.robot_click(driver);
		robot.delay(500);
		robot.mouseMove(400,205);
		robot.delay(500);
		elements.robot_click(driver);
		robot.delay(500);
		//elements.robot_enter(driver);
		//driver.findElement(By.id("txtCat")).sendKeys("C:\\Users\\segal\\OneDrive\\׳×׳�׳•׳ ׳•׳×\\2.2");*/
		 boolean isselct;
		 isselct =driver.findElement(By.id("rv-agreement")).isSelected();
			if (isselct==true) {driver.findElement(By.xpath("//*[@class=\"filling-content\"]/button ")).click();}
			else {driver.findElement(By.id("rv-agreement")).click();
			driver.findElement(By.xpath("//*[@class=\"filling-content\"]/button")).click();}
			
			//׳©׳�׳‘ ׳‘׳—׳™׳¨׳× ׳₪׳�׳˜׳₪׳•׳¨׳�׳”
			if (driver.findElement(By.id("loginWithGoogleBtn"))!=null) 
			{test.pass("there is goggle button");	
			} else {test.fail(" there is not facebook button",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			}
			
			if (driver.findElement(By.id("loginWithFacebookBtn"))!=null) 
			{test.pass("there is facebook button");
				elements.facebookRate_click(driver);	
			} else {test.fail(" there is not facebook button",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			}
			
			
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			elements.Facebook(driver);
			driver.switchTo().window(tabs2.get(0));
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 WebDriverWait myDynamicElement = (new WebDriverWait(driver, 10));
					 until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\\\"rv-tnx bp-sub-sec-hdl\\\"]")));

			 //׳‘׳ ׳×׳™׳™׳� ׳�׳� ׳¢׳•׳‘׳“
			 String thank_you_for_shering=driver.findElement(By.xpath("//*[@class=\"rv-tnx bp-sub-sec-hdl\"]")).getText();
			 
			 if (thank_you_for_shering.contains("׳×׳•׳“׳” ׳©׳©׳™׳×׳₪׳× ׳�׳•׳×׳ ׳•!")) {test.pass("sher rat warking");
				
			} else {test.fail("sher rat are not warking",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
			}
			driver.findElement(By.id("_popupClose")).click();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(1000);
			elements.B144logo(driver);
	}
	
	private static void until(ExpectedCondition<WebElement> presenceOfElementLocated) {
		// TODO Auto-generated method stub
		
	}
	//***************************************׳¢׳•׳�׳� ׳”׳§׳•׳₪׳•׳ ׳™׳�**********************************************************************
	public static void kopon_world() throws InterruptedException, IOException, AWTException {
		elements.hamborger_Button(driver);
		Thread.sleep(500);
		elements.hamborger_search(driver).get(1).click();
		elements.hamborger_kopon_wrold(driver).get(0).click();
		
		String H2=elements.H2_kopon(driver);
		if (H2=="׳¢׳•׳�׳� ׳”׳§׳•׳₪׳•׳ ׳™׳�") {	test.pass("kopon world page pass");
		}
		else {test.fail("kopon world page faill",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());	
		}
		
		elements pom1= PageFactory.initElements(driver, elements.class);
		pom1.kopon_search_cat.sendKeys("׳�׳¡׳¢׳“׳•׳×");
		//pom.kopon_search_cat(driver).sendKeys("׳�׳¡׳¢׳“׳•׳×");
		pom.kopon_search_city(driver).sendKeys("׳ ׳×׳ ׳™׳”");
		elements.kopon_search_click(driver);
		//׳©׳�׳™׳—׳× ׳§׳•׳₪׳•׳� ׳�׳�׳¡׳₪׳¨ ׳₪׳�׳�׳₪׳•׳�
		elements.kopon(driver);
		pom.phoneCop(driver).sendKeys("0502011359");
		pom.send_phone_num(driver).click();
		elements.close_kodeCop(driver);
		//׳©׳™׳×׳•׳£ ׳§׳•׳₪׳•׳� ׳¢׳� ׳₪׳™׳™׳¡׳‘׳•׳§
		elements.kopon(driver);
		elements.shereFacebook(driver);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		elements.Facebook(driver);
		if (driver.findElement(By.xpath("//*[@class=\"unclickableMask\"]")) != null) {
			test.pass("kopon sher is good",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());	
			driver.close();
		}
		
		
		else {test.fail("kopon sher is not good",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());	
		driver.close();
		}
		driver.switchTo().window(tabs2.get(0));
		elements.closeCop(driver);
		elements.B144logo(driver);	
	}
	//********************************************׳—׳™׳₪׳•׳© ׳�׳ ׳©׳™׳�******************************************************
	
	public static void search_people() throws InterruptedException, IOException, AWTException {
		elements pom1= PageFactory.initElements(driver, elements.class);
		elements.search_people(driver);
		pom1.searchPeopleBar.sendKeys("׳�׳©׳” ׳›׳”׳�");;
		//pom.searchPeopleBar(driver).sendKeys("׳�׳©׳” ׳›׳”׳�");
		pom.searchCityPeopleBar(driver).sendKeys("׳—׳™׳₪׳”");
		elements.search_people_Button(driver);
		elements.peopleResults(driver);
		driver.navigate().back();
		//pom.searchPeopleBar(driver).clear();
		//pom.searchPeopleBar(driver).sendKeys("׳�׳‘׳™ ׳’׳¨׳‘׳™");
		pom1.searchPeopleBar.clear();
		pom1.searchPeopleBar.sendKeys("׳�׳‘׳™ ׳’׳¨׳‘׳™");
		pom.searchCityPeopleBar(driver).clear();
		elements.search_people_Button(driver);
		String H1people=elements.H1people(driver);
		assertEquals(H1people, "׳�׳‘׳™ ׳’׳¨׳‘׳™");
		elements.peopleResults(driver);
		if (driver.findElement(By.xpath("//*[@class=\"pc-buttons\"]")) != null) {test.pass("show number and send me SMS desplay");
		}
		else {test.fail("kopon sher is not good",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());	
		}
		elements.B144logo(driver);
	}
	
	//*****************************************׳�׳₪׳•׳×*********************************************************
	
	public static void maps() throws InterruptedException, IOException, AWTException {
		elements.hamborger_Button(driver);
		elements.hamborger_search(driver).get(0).click();
		elements.hamborger_insaidMenu(driver).get(2).click();
		Thread.sleep(1000);
		pom.searchCity_maps(driver).sendKeys("׳–׳‘׳•׳˜");
		Thread.sleep(1000);
		elements.maps_autocom_list(driver).get(0).click();
		elements.maps_search_But(driver);
		if (driver.findElement(By.id("moreDetalisFullMemberDetalis0")) != null) {
			test.pass("maps more details show");
			elements.B144logo(driver);
		}
		else {test.fail("kopon sher is not good",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());	
		}
		}
	//***********************************************׳�׳™ ׳₪׳ ׳•׳™****************************************************
	
	public static void MiPanoey() throws InterruptedException, IOException, AWTException {
		try {elements.MiPanoey_cov19(driver);
			
		} catch (Exception e) {	
		}
		pom.MiPanoey_search(driver).sendKeys("׳¦׳‘׳™׳¢׳× ׳‘׳“׳™׳�");
		elements.MiPanoey_search_btn(driver);
		Thread.sleep(1000);
		pom.MiPanoey_reasonText(driver).sendKeys("׳‘׳“׳™׳§׳” ׳™׳•׳�׳™׳×");
		pom.MiPanoey_txtAddress(driver).sendKeys("׳—׳™׳₪׳”");
		Thread.sleep(1000);
		elements.MiPanoey_cityList(driver);
		Thread.sleep(1000);
		pom.MiPanoey_phoneNum(driver).sendKeys("0506361974");
	//	Robot robot=new Robot();
		driver.findElement(By.id("uploadImg")).click();
		Thread.sleep(3000);
		/*Robot robot=new Robot();
		robot.mouseMove(40,220);
		robot.delay(500);
		elements.robot_click(driver);
		robot.delay(500);
		robot.mouseMove(400,205);
		robot.delay(500);
		elements.robot_click(driver);
		robot.delay(1500);
		elements.robot_enter(driver);*/
		elements.writeString("c:\\java niso\\2.png");
		elements.robot_enter(driver);
		
		//driver.findElement(By.id("uploadImg")).sendKeys("C:\\Users\\segal\\Downloads\\IMG-20200906-WA0034.jpg");
		boolean isselct;
		 isselct =driver.findElement(By.id("gridCheck1")).isSelected();
			if (isselct==true) {driver.findElement(By.xpath("//*[@class=\"btn greenBtn\"]"));}
			else {driver.findElement(By.id("gridCheck1")).click();}
			
			
	}

	 public static void  ww() throws InterruptedException, IOException, AWTException  {
	 Categories_H1.excel(driver);
	 }
	 public static void afterClass() throws InterruptedException {
		 extent.flush();
		  driver.quit();
	  }
}