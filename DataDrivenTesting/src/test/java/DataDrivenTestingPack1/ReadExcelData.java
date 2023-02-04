package DataDrivenTestingPack1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadExcelData
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		List<String> list=new ArrayList<String>();
		for(int i=0;i<4;i++)
		{
			String data=wb.getSheet("skillrary").getRow(i).getCell(1).getStringCellValue();
			list.add(data);
		}
		System.out.println(list);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(list.get(0));
		long time=Long.parseLong(list.get(3));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.findElement(By.id("email")).sendKeys(list.get(1)+Keys.TAB+list.get(2)+Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		boolean status=wait.until(ExpectedConditions.titleContains("SkillRary Ecommerce"));
		if(status)
			System.out.println("Pass");
		else
			System.out.println("Fail");
		driver.quit();
		
	}

}
