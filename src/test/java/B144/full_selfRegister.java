package B144;

import java.awt.AWTException;
import java.awt.geom.Area;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class full_selfRegister {

	static WebDriver driver;
	static reportFanction t3 = new reportFanction(driver);
	static ExtentReports extent;
	static ExtentTest test;
	static String name;
	static String name_not_good;
	static String bisName;
	static String bisname_not_good;
	static String phone;
	static String phone_are_not_good;
	static String email;
	static String email_are_not_good;
	
	public static void selfRegister_level1(WebDriver driver) throws IOException, InterruptedException, AWTException {
		extent =t3.GetExtent();
		test = t3.createTest("regrsion test", "self Register level1");
		elements pom1= PageFactory.initElements(driver, elements.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*name=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[2]/div[1]/span[1]")).getText();
		 name_not_good="יש למלא את שם איש הקשר";
		 bisName=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[3]/div[1]/span[1]")).getText();
		 bisname_not_good="יש למלא את שם העסק";
		 phone=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[4]/div[1]/span[1]")).getText();
		 phone_are_not_good="יש להעלות מספר נייד תקני ללא מקף, רווח או תווים";
		 email=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[5]/div[1]/span[1]")).getText();
		 email_are_not_good="יש למלא כתובת אימייל";
		 
		/*elements.selfRegister_level1_next_btn(driver);
		//test.skip("Without text");
		Thread.sleep(1500);
		name();
		bisname();
		phone();
		email();
		driver.navigate().refresh();*/
		
		pom1.selfRegister_level1_name.sendKeys("#@#$#@$");
		pom1.selfRegister_level1_bisName.sendKeys("#@#$#@$");
		pom1.selfRegister_level1_phone.sendKeys("#@#$#@$");
		pom1.selfRegister_level1_email.sendKeys("#@#$#@$");
		elements.selfRegister_level1_next_btn(driver);
		Thread.sleep(1000);
		
		test.skip("With symbol text");
		 name=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[2]/div[1]/span[1]")).getText();
		 name_not_good="יש למלא את שם איש הקשר";
		
		name();
		
		 bisName=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[3]/div[1]/span[1]")).getText();
		 bisname_not_good="יש למלא את שם העסק";
		bisname();
		
		 phone=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[4]/div[1]/span[1]")).getText();
		 phone_are_not_good="יש להעלות מספר נייד תקני ללא מקף, רווח או תווים";
		 phone();
		
		 email=driver.findElement(By.xpath("//*[@class=\"contact-content--right\"]/div[5]/div[1]/span[1]")).getText();
		 email_are_not_good="יש למלא כתובת אימייל";
		email();
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		elements.selfRegister_level1_next_btn(driver);
		test.skip("Without text");
		Thread.sleep(1500);
		name();
		bisname();
		phone();
		email();
		driver.navigate().refresh();
		
		
		extent.flush();
			
	}
	public static void name() throws AWTException, IOException {
		if (name.equals(name_not_good)) {test.pass("the same error text(name)");
	}
		else {test.fail("not the same error text",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
	}	
	}
    public static void bisname() throws AWTException, IOException {	
    	if (bisName.equals(bisname_not_good)) {test.pass("the same error text(bisName)");
	}
    	else {test.fail("not the same error text",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
	}
	}
    public static void phone() throws AWTException, IOException {
    	if (phone.equals(phone_are_not_good)) {test.pass("the same error text(phone)");
	}
    	else {test.fail("not the same error text",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
	}
    }
    public static void email() throws AWTException, IOException {
    	if (email.equals(email_are_not_good)) {test.pass("the same error text(email)");
	}
    	else {test.fail("not the same error text",MediaEntityBuilder.createScreenCaptureFromPath(t3.CaptureScreen(driver)).build());
	}
    }
    
}
