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
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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
	
	
	
	static String path="C:\\java niso//��excel_cat.xlsx";
	private static int rowNumber;
	private static int cellNumber;
	
	public static void excel(WebDriver driver) throws IOException, InterruptedException {
	
		try {
			
		
	FileInputStream fis = new FileInputStream (path);
	XSSFWorkbook wb = new XSSFWorkbook (fis);
	XSSFSheet sheet = wb.getSheet("test");
	
	
	int kidom=0;
	while(kidom<10) {
	XSSFRow row = sheet.getRow(kidom);
	XSSFCell cell = row.getCell(0);
	String value = cell.getStringCellValue();
	driver.findElement(By.id("txtCat")).clear();
	driver.findElement(By.id("txtCat")).sendKeys(value);
	elements.search_button(driver);
	
	
	Thread.sleep(500);
	
		String h1=	elements.H1(driver);
		
	
	Thread.sleep(1000);

	


	
	excelPrint(path, h1, kidom, 1);
	
		String num_biS=driver.findElement(By.id("baseMasterContent_Content_searchResultsNum")).getText();
	excelPrint_num(path, num_biS, kidom, 1);
	kidom++;
	}
		} catch (Exception e) {
		driver.navigate().back();
		
		excel(driver);}
		
		
			
		
}
	

		


		public static void excelPrint(String Path, String h1, int rowNumber, int cellNumber) {

			     
			   try {
		//����� ���� �����
		FileInputStream inputStream = new FileInputStream(new File(Path));
		 Workbook workbook = WorkbookFactory.create(inputStream);
		//���� ������
		 Sheet sheet = workbook.getSheetAt(0);//����� ����
		//���� �����
		Row r = sheet.getRow(rowNumber);
		 
		//��������� � ����� �� ����� ���� �� ��� �� ����� ���� ����
		 if (r == null) {
		//����� ����� ������
		r = sheet.createRow(rowNumber);
			        }

		//����� ������ ������. ����� ��� ����� ���
		Cell c = r.getCell(cellNumber);

		 if (c == null) {

			  c=r.createCell(cellNumber);
			        			
			        }
		//����� ���� ��� ����� �����
		 c.setCellValue(h1);
		 
			
		//����� ����� �������    
		 FileOutputStream outputStream = new FileOutputStream(Path);
		 workbook.write(outputStream);
		workbook.close();
		outputStream.close();
			         
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }


		
	}
		public static void excelPrint_num(String Path, String num_bis, int rowNumber, int cellNumber) {

		     
			   try {
		//����� ���� �����
		FileInputStream inputStream = new FileInputStream(new File(Path));
		 Workbook workbook = WorkbookFactory.create(inputStream);
		//���� ������
		 Sheet sheet = workbook.getSheetAt(0);//����� ����
		//���� �����
		Row r = sheet.getRow(rowNumber);
		 
		//��������� � ����� �� ����� ���� �� ��� �� ����� ���� ����
		 if (r == null) {
		//����� ����� ������
		r = sheet.createRow(rowNumber);
			        }

		//����� ������ ������. ����� ��� ����� ���
		Cell c = r.getCell(2);

		 if (c == null) {

			  c=r.createCell(2);
			        			
			        }
		 
		//����� ���� ��� ����� �����
		 c.setCellValue(num_bis);
		 
			
		//����� ����� �������    
		 FileOutputStream outputStream = new FileOutputStream(Path);
		 workbook.write(outputStream);
		workbook.close();
		outputStream.close();
			         
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }


		
	}
	
	
}
