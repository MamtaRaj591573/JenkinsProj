package DataDrivenTestingPack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("skill");
		///Row r=sh.createRow(3);
		Row r=sh.getRow(3);
		Cell c=r.createCell(1);
		c.setCellValue(10);
		FileOutputStream efos=new FileOutputStream("./src/test/resources/Emp_Detail.xlsx");
		book.write(efos);
		book.close();
		

	}

}
