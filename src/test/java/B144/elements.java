package B144;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.Get;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

 




public class elements {
	
//****************************************����� ����� �� B144 ������ ��� ����**************************************
	 public  static void B144logo(WebDriver driver) {
			
			driver.findElement(By.id("logoB144")).click();
		}
//****************************************����� �� ����� ����**************************************

	public  static void selfRegisterLink(WebDriver driver) {
		
		driver.findElement(By.id("joinBusiness")).click();
	}
//****************************************��� �� ����� �����**************************************

	public  WebElement  search_Business_bar(WebDriver driver) {
		WebElement search_Business_bar =driver.findElement(By.id("txtCat"));
		return search_Business_bar;
	}
//****************************************��� �� ����� ��� ����� �����**************************************
	
	public  WebElement  search_city_bar(WebDriver driver) {
		WebElement search_city_bar =driver.findElement(By.id("txtCity"));
		return search_city_bar;
	}
//****************************************����� ����� �����**************************************
	public  static void search_button(WebDriver driver) {
		driver.findElement(By.id("b_BusinessSearch")).click();
	}
//****************************************����� H1 ������� �����**************************************
	 public static String H1(WebDriver driver) {
	String H1 = driver.findElement(By.id("titleHdr")).getText();
	return H1;
	 }
//****************************************����� ����� ������ �������� �� ����� �����**************************************
	public static int display_number(WebDriver driver) {
	 int first3_size_Number =driver.findElements(By.xpath("//*[@class=\"button button--white show-phone-num buttom_cursor btn--red\"]")).size();
	return first3_size_Number;
	 }
//****************************************����� �� ������ ��� ������� �� ���� �� ����**************************************
	public static int  numbers_dont_display(WebDriver driver) {
		int diplay_bis_numbers=driver.findElements(By.xpath("//*[@class=\"button button--orange buttom_cursor btn--red\"]\r\n")).size();
				return diplay_bis_numbers;
	}
//****************************************����� ������ ������ ������� �����**************************************
	public  static void more_options(WebDriver driver) {
		driver.findElement(By.id("moreResultsButton")).click();
	}
//****************************************����� ��������� �� ��� ������ ����**************************************
	public  static void bissList (WebDriver driver) {
		Random random=new Random();
		List<WebElement> bissList= driver.findElements(By.xpath("//*[@class=\"text ellipsis\"]"));
		bissList.get(random.nextInt(bissList.size())).click();
	}
//****************************************���� ����� ����� ���� ��� ���**************************************
	public  static String service_location(WebDriver driver) {
		String service_location= driver.findElement(By.xpath("//*[@class=\"service-location\"]")).getText();
		return service_location;
	}
	//****************************************����� �� ���� ���� ����� ���**************************************
	public  WebElement service_location_butt(WebDriver driver) {
		WebElement service_location_butt=driver.findElement(By.xpath("//*[@class=\"bcard-section-content\"]/div[4]/a"));
				return service_location_butt;
	}
//****************************************����� ����� �� �����**************************************
	public static void robot_click(WebDriver driver ) throws AWTException {
		Robot robot=new Robot();
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	robot.delay(500);
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	robot.delay(500);
	}
//****************************************����� ����� �� ����**************************************
	public static void robot_enter(WebDriver driver) throws AWTException {
		Robot robot=new Robot();
		robot.mousePress(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.mouseRelease(KeyEvent.VK_ENTER);
	}
//****************************************����� �� ������� ������ ���� ����� ������ ��������� ���� ��������**************************************
	public static List<WebElement> hamborger_search(WebDriver driver) {
		List<WebElement>hamborger_search=driver.findElements(By.xpath("//*[@class=\"menu-item item-dropdown\"]"));
		return hamborger_search;
	}
//****************************************����� �� �� �� ����� ���� ������ ���� ��������� **************************************
	public static List<WebElement>hamborger_kopon_wrold(WebDriver driver){
	List<WebElement>hamborger_kopon_wrold=driver.findElements(By.xpath("/html/body/form/header/div[3]/div/div/div/div[1]/div/div[2]/div[3]/div[1]/div"));
	return hamborger_kopon_wrold;
	}
//****************************************������ �� ���� ��������**************************************
	public static String H2_kopon(WebDriver driver) {
	String H2_kopon= driver.findElement(By.xpath("//*[@class=\"coupons-world-title\"]")).getText();
		return  H2_kopon ;	
	}
//****************************************����� �������� ���� ������**************************************
	/*public WebElement kopon_search_cat(WebDriver driver) {
		WebElement kopon_search_cat=driver.findElement(By.id("txtCategoryInput"));
		return kopon_search_cat;
	}*/
	//@FindBy (how = How.ID, using  = "txtCategoryInput")
	@FindBy(id="txtCategoryInput")
	public WebElement kopon_search_cat ;
//****************************************��� ����� ��� ���� ������**************************************
	public WebElement kopon_search_city(WebDriver driver) {
		WebElement  kopon_search_city=driver.findElement(By.id("txtBusinessCityInput"));
		return  kopon_search_city;
	}
//****************************************����� ����� ���� ������**************************************
	public static void kopon_search_click(WebDriver driver) {
		driver.findElement(By.id("coupon_b_BusinessSearch")).click();
	}
//****************************************���� ������ ������ ����**************************************
	public static void  kopon(WebDriver driver) {
		Actions goTo=new Actions(driver);
			WebElement element=driver.findElement(By.xpath("//*[@class=\"cw-coupon-item coupon-shadow\"]"));
		goTo.moveToElement(element).perform();	
		driver.findElement(By.xpath("//*[@class=\"btn btn--orange cw-coupon-btn\"]")).click();
		}
//****************************************����� ��� ���� ������ �� �������**************************************
	public static void shereFacebook(WebDriver driver) {
		driver.findElement(By.id("faceBookShare")).click();
	}
//****************************************������� ��������**************************************
	public static void Facebook(WebDriver driver) throws InterruptedException, AWTException {
		if (driver.findElement(By.id("email"))!= null) {
			driver.findElement(By.id("email")).clear();
		}
		driver.findElement(By.id("email")).sendKeys("0503042873");
        driver.findElement(By.id("pass")).sendKeys("qwe321!");
        Thread.sleep(500);
        driver.findElement(By.id("loginbutton")).click();  
	}
//****************************************����� �����**************************************
	public static void closeCop(WebDriver driver) {
		driver.findElement(By.xpath("//*[@class=\"cp-close\"]")).click();
	}
//****************************************��� ����� ���� ���� ������**************************************
	public WebElement phoneCop(WebDriver driver) {
		WebElement  phoneCop=driver.findElement(By.id("phone-num-input"));
		return  phoneCop;
		}
//****************************************����� ����� ������**************************************
	public WebElement send_phone_num(WebDriver driver) {
		WebElement  send_phone_num=driver.findElement(By.id("send-phone-num"));
		return  send_phone_num;
		}
//****************************************����� ���� ���� ����� �����**************************************
	public static void close_kodeCop(WebDriver driver) {
		driver.findElement(By.xpath("//*[@class=\"cp-coupon-verified\"]/button")).click();
	}
//****************************************��� ����� �� ����**************************************
	@FindBy(id = "txtNamePrivate")
	public WebElement searchPeopleBar;
//****************************************����� ����� �����**************************************	
	public static void search_people(WebDriver driver) {
		driver.findElement(By.id("bezekDrop-dropDown")).click();
	}/*
	public WebElement searchPeopleBar (WebDriver driver) {
		WebElement  searchPeopleBar=driver.findElement(By.id("txtNamePrivate"));
		return  searchPeopleBar;
		}*/
//****************************************��� ����� ��� ������ �����**************************************
	public WebElement searchCityPeopleBar (WebDriver driver) {
		WebElement  searchCityPeopleBar=driver.findElement(By.id("txtCityPrivate"));
		return  searchCityPeopleBar;
		}
//****************************************����� ����� ������**************************************
	public static void search_people_Button(WebDriver driver) {
		driver.findElement(By.id("b_PrivateSearch")).click();
	}
//****************************************����� ���� ������� ������**************************************
	public static List<WebElement>peopleResults(WebDriver driver){
		Random random=new Random();
		List<WebElement>peopleResults=driver.findElements(By.xpath("//*[@class=\"card-list-item statPhoneCard\"]"));
		peopleResults.get(random.nextInt(peopleResults.size())).click();
		return peopleResults;
		}
//****************************************����� H1 ������ �����**************************************
	public static String H1people(WebDriver driver) {
		String H1people = driver.findElement(By.xpath("//*[@class=\"search-results-hdl\"]")).getText();
		return H1people;
	}
//****************************************��� ���� ���� �� ������ ����� ������ ����**************************************
	public static String privetCard(WebDriver driver) {
		String privetCard = driver.findElement(By.xpath("//*[@class=\"pc-buttons\"]")).getText();
		return privetCard;
	}
//****************************************����� �������**************************************
	public static void hamborger_Button(WebDriver driver) {
		driver.findElement(By.xpath("//*[@class=\"hamburger hamburger--3dx\"]")).click();
	}
//****************************************������� �� ������� ����� ������� ������ ���� ����� ���������**************************************
	public static List<WebElement>hamborger_insaidMenu(WebDriver driver){
		List<WebElement>hamborger_insaidMenu=driver.findElements(By.xpath("//*[@class=\"dropdown-wrapper\"]/div/a"));
		return hamborger_insaidMenu;
		}
//****************************************��� ����� ����� �����**************************************
	public WebElement searchCity_maps (WebDriver driver) {
		WebElement  searchCity_maps=driver.findElement(By.id("map-search"));
		return  searchCity_maps;
		}
//****************************************����� �������� �� ����� ����**************************************
	public static List<WebElement>maps_autocom_list(WebDriver driver){
		List<WebElement>maps_autocom_list=driver.findElements(By.xpath("//*[@class=\"ui-menu ui-widget ui-widget-content ui-autocomplete ui-front\"]/li"));
		return maps_autocom_list;
	}
//****************************************����� ����� ����**************************************
	public static void maps_search_But(WebDriver driver) {
		driver.findElement(By.id("btn_submit_address")).click();
	}
//**************************************�� ���� ����� �����**************************************
	public WebElement MiPanoey_search (WebDriver driver) {
		WebElement  MiPanoey_search=driver.findElement(By.id("txtCategory"));
		return  MiPanoey_search;
	}
//****************************************����� ����� ��� ����**************************************
	public static void MiPanoey_search_btn (WebDriver driver) {
		driver.findElement(By.xpath("//*[@class=\"inputRow\"]")).click();
	}
//****************************************����� ��� ���� ���� ������ �����**************************************
	public static void MiPanoey_cov19 (WebDriver driver) {
		driver.findElement(By.xpath("//*[@class=\"covid-19\"]")).click();
	}
//****************************************�� ���� ���� ����� ���**************************************
	public WebElement MiPanoey_reasonText (WebDriver driver) {
		WebElement  MiPanoey_reasonText=driver.findElement(By.id("reasonText"));
		return  MiPanoey_reasonText;
	}
//****************************************�� ���� ��� �����**************************************
	public WebElement MiPanoey_txtAddress (WebDriver driver) {
		WebElement  MiPanoey_reasonText=driver.findElement(By.id("txtAddress"));
		return  MiPanoey_reasonText;
	}
//****************************************�� ���� ��� ���� �����**************************************
	public WebElement MiPanoey_phoneNum (WebDriver driver) {
		//WebElement  MiPanoey_phoneNum=driver.findElement(By.name("phoneNum"));
		WebElement  MiPanoey_phoneNum=driver.findElement(By.xpath("//*[@class=\"form-group phone-section\"]/input"));
		return  MiPanoey_phoneNum;
	}
//****************************************�� ���� ��� ����� ���**************************************
	public static List<WebElement> MiPanoey_cityList(WebDriver driver){
		Random random=new Random();
		List<WebElement>MiPanoey_cityList=driver.findElements(By.xpath("/html/body/ul[2]/li"));
		MiPanoey_cityList.get(random.nextInt(MiPanoey_cityList.size())).click();
		return MiPanoey_cityList;
	}
//****************************************����� ���� ��� 2 ���� ������**************************************
	public WebElement selfRegister_phone_level2 (WebDriver driver) {
		WebElement  selfRegister_phone_level2=driver.findElement(By.id("input_businessPhoneNumber"));
		return  selfRegister_phone_level2;
		}
//****************************************����� ���� ��� 2 ��� ���**************************************
	public WebElement selfRegister_city_level2 (WebDriver driver) {
		WebElement  selfRegister_city_level2=driver.findElement(By.id("input_businessCity"));
		return  selfRegister_city_level2;
		}
//****************************************����� �������� ��� ����� ���� ��� 2**************************************
	public static List<WebElement> cityList_level2(WebDriver driver) {
		List<WebElement>cityList_level2=driver.findElements(By.xpath("//*[@class=\"auto-complete-item input-complete ui-menu-item\"]"));
		return cityList_level2;
	}
//****************************************��� ���� ����� ���� ��� 2*************************************
	public WebElement selfRegister_street_level2 (WebDriver driver) {
		WebElement  selfRegister_street_level2=driver.findElement(By.id("input_businessStreet"));
		return  selfRegister_street_level2;
		}
//****************************************����� ������ ���2 ����� ����**************************************
	public static List<WebElement> StreetList_level2(WebDriver driver) {
		List<WebElement>StreetList_level2=driver.findElements(By.xpath("//*[@id=\"ui-id-3\"]/li"));
		return StreetList_level2;
	}
//****************************************����� ����� �� �������**************************************
	public static void facebookRate_click(WebDriver driver) {
		driver.findElement(By.id("loginWithFacebookBtn")).click();
	}
	 public static void writeString(String s) throws AWTException {
Robot robot=new Robot();
         for (int i = 0; i < s.length(); i++) {

             char c = s.charAt(i);

             if (Character.isUpperCase(c)) {

                 robot.keyPress(KeyEvent.VK_SHIFT);

             }

             robot.keyPress(Character.toUpperCase(c));
             robot.delay(500);

             robot.keyRelease(Character.toUpperCase(c));
             robot.delay(500);


             if (Character.isUpperCase(c)) {

                 robot.keyRelease(KeyEvent.VK_SHIFT);

             }

         }

         robot.delay(100);

   

}

	
}

