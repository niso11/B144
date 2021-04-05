package B144;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;

import javax.swing.text.html.parser.Element;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.google.inject.spi.Elements;



public class Categories_H1 {
	
	
	
	static String path="C:\\java niso//‏‏excel_cat.xlsx";
	private static int rowNumber;
	private static int cellNumber;
	
	public static void excel(WebDriver driver) throws IOException, InterruptedException {
	
	FileInputStream fis = new FileInputStream (path);
	XSSFWorkbook wb = new XSSFWorkbook (fis);
	XSSFSheet sheet = wb.getSheet("test");
	
	int kidom=0;
	while(kidom<11) {
	XSSFRow row = sheet.getRow(kidom);
	XSSFCell cell = row.getCell(0);
	String value = cell.getStringCellValue();
	driver.findElement(By.id("txtCat")).clear();
	driver.findElement(By.id("txtCat")).sendKeys(value);
	elements.search_button(driver);
	
	
	Thread.sleep(500);
	String h1=	elements.H1(driver);
	
	Thread.sleep(2000);

	

/*
	FileInputStream inputStream = new FileInputStream(new File(path));
	Workbook workbook = WorkbookFactory.create(inputStream);
    Sheet sheet1 = workbook.getSheetAt(0);
	Row r = sheet1.getRow(kidom);
	r=sheet1.createRow(0);
	Cell c = r.getCell(1);
	
	
	
				        			
		  
		        			
		       
	c.setCellValue(h1);

	FileOutputStream outputStream = new FileOutputStream(path);
 	workbook.write(outputStream);
	workbook.close();
	outputStream.close();
	
	*/excelPrint(path, h1, kidom, 1);
	kidom++;
	}
}
	

		public static void excelPrint(String Path, String h1, int rowNumber, int cellNumber) {

		
			     
			   try {
		//פתיחת קובץ האקסל
		FileInputStream inputStream = new FileInputStream(new File(Path));
		 Workbook workbook = WorkbookFactory.create(inputStream);
		//פניה לגליון
		 Sheet sheet = workbook.getSheetAt(0);//גליון מספר
		//פניה לשורה
		Row r = sheet.getRow(rowNumber);
		 
		//אופציונלי – בדיקה אם השורה ריקה על מנת לא לדרוס משהו קיים
		 if (r == null) {
		//ניתוב לשורה הרצויה
		r = sheet.createRow(rowNumber);
			        }

		//ניתוב לעמודה הרצויה. במקרה הזה עמודה אחת
		Cell c = r.getCell(cellNumber);

		 if (c == null) {

			  c=r.createCell(cellNumber);
			        			
			        }
		//הדפסת הערך לתא הנבחר בטבלה
		 c.setCellValue(h1);
		 
			
		//כתיבה לקובץ וסגירתו    
		 FileOutputStream outputStream = new FileOutputStream(Path);
		 workbook.write(outputStream);
		workbook.close();
		outputStream.close();
			         
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }


		
	}
	
	
}
