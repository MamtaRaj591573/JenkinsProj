package DataDrivenTestingPack1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VtigerLogin
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		long time=Long.parseLong(pro.getProperty("timeouts"));
		//String BROWSER=pro.getProperty("browser");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		boolean status=wait.until(ExpectedConditions.titleContains("Home"));
		//System.out.println(status);
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
				
		FileInputStream efis=new FileInputStream("./src/test/resources/Jan5.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("product");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		Random ran=new Random();
		int rannum=ran.nextInt(1000);
		String prod_data=cel.getStringCellValue()+rannum;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prod_data);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	
		
		
		

	}

}
