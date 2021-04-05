package B144;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportFanction {
	
	public WebDriver driver;

	public reportFanction(WebDriver driver){               
        this.driver=driver;     
    }
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	static Date today = Calendar.getInstance().getTime(); 
	static String reportDate = df.format(today);
	public static String filePath = "C:\\java niso\\"+reportDate+"\\exReport.html";
	
	public static ExtentReports GetExtent(){
		new File("C:\\java niso\\"+ reportDate).mkdirs();
				if (extent != null)
		                return extent; //avoid creating new instance of html file
		                extent = new ExtentReports();		
				extent.attachReporter(getHtmlReporter());
				return extent;
			}

	private static ExtentSparkReporter getHtmlReporter() {
		
		
		htmlReporter = new ExtentSparkReporter(filePath);
		htmlReporter.config().setDocumentTitle("practist 1");
        htmlReporter.config().setReportName("Regression cycle");
        htmlReporter.config().setEncoding("utf-8"); 
        return htmlReporter;
        
	}
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
	}
	
	public static String CaptureScreen(WebDriver driver) throws AWTException, IOException{
		LocalDateTime now = LocalDateTime.now();
		String  time =now.format(DateTimeFormatter.ofPattern("ddHHmmss")); 		
		String folderPath = ("C:\\java niso\\"+reportDate);
		String imagePath   = folderPath  +"/pic" +time +".jpg"; 
		//String imagePath   = "c:\\a.jpg";
		System.out.println(imagePath);
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(imagePath);
		FileUtils.copyFile(oScnShot, oDest);
		return imagePath;

	}


}
