package com.OrangeCRM.utlis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.OrangCRM.pages.objects.AdminPage;
import com.OrangCRM.pages.objects.LoginPage;
import com.OrangCRM.pages.objects.PIMPage;
import com.OrangeCRM.elementloctors.OC;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends OC {
	public static WebDriver driver;
	public static LoginPage lp;
	public static PIMPage pp;
	public static AdminPage ap;

	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod//Before Excuting any test@ before it will excute and it will go back to test@
	public void OpenApp() {
		setup();
		lp = new LoginPage();
		lp.doLogin("Admin", "admin123");
		pp = new PIMPage();
		ap=new AdminPage();
	}
	public static String getcellData(String sheetName, int rowNum, int colNum) throws IOException {
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Orange_Data.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet s = w.getSheet(sheetName);
		XSSFRow r = s.getRow(rowNum);
		XSSFCell c = r.getCell(colNum);
		return c.getStringCellValue();
	}

	public static Object[][] getData(String TcName, String sheetName) throws IOException {
		int Tcrow = 0;
		while (!getcellData(sheetName, Tcrow, 0).equals(TcName)) {
			Tcrow++;
		}
		System.out.println(Tcrow);
		int colRow = Tcrow + 1;
		int cols = 0;

		while (!getcellData(sheetName, colRow, cols).equals("N")) {
			cols++;
		}
		System.out.println(cols);
		int dataRow = Tcrow + 2;//
		int rows = 0;

		while (!getcellData(sheetName, dataRow + rows, 0).equals("N")) {
			rows++;
		}
		System.out.println(rows);
		int index = 0;
		Object[][] data = new Object[rows][1];
		HashMap<String, String> map;
		for (int i = dataRow; i < dataRow + rows; i++) {
			map = new HashMap();
			for (int j = 0; j < cols; j++) {
				System.out.println(getcellData(sheetName, i, j));
				String key = getcellData(sheetName, colRow, j);
				System.out.println(key);
				String value = getcellData(sheetName, i, j);
				System.out.println(value);
				map.put(key, value);
			}
			data[index][0] = map;
			index++;
		}
		return data;
	}

	public static void wrightSpecificDataToDataSheet(String SheetName, String colName, String data, String TcName)
			throws IOException {
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Orange_Data.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(f);
		XSSFSheet s = w.getSheet(SheetName);
		int tcRow = 0;
		int colNum = 0;
		while (!getcellData(SheetName, tcRow, 0).equals(TcName)) {
			tcRow++;
		}
		System.out.println(tcRow);
		XSSFRow r = s.getRow(tcRow + 1);
		XSSFCell c;

		for (int i = 0; i < r.getLastCellNum(); i++) {
			// System.out.println(r.getCell(i).getStringCellValue());
			if (r.getCell(i).getStringCellValue().equals(colName)) {
				colNum = i;
			}
		}
		r = s.getRow(tcRow + 2);
		c = r.getCell(colNum);
		c.setCellValue(data);
		FileOutputStream p = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\Orange_Data.xlsx");
		w.write(p);
		p.close();
		f.close();
	}

	public static void main(String[] args) throws IOException {
		// System.out.println(getcellData("Sheet1",0,0));
		//getData("TC-1CrtEm", "Sheet1");
		 wrightSpecificDataToDataSheet("Sheet1","EmployeName","Noah","TC2_EditEm" );
	}
	
	public void selectDropdown(WebElement Drop,String value) {
		WebElement box=driver.findElement(By.xpath("//div[@role='listbox']"));
		List<WebElement>items=Drop.findElements(By.tagName("div"));
		for(WebElement item:items) {
			if(item.getText().equals(value)) {
			item.click();
			break;
     }
   }
}
	
	public static int getRandomNum() {
		Random r=new Random();
		return r.nextInt(50);
	}
}
