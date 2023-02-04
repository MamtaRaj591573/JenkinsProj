package DataDrivenTestingPack1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("emp");
//		Row row=sh.getRow(1);
//		Cell cel=row.getCell(1);
//		String data=cel.getStringCellValue();
//		System.out.println(data);
		int rows=sh.getLastRowNum();
		int cells=sh.getRow(0).getLastCellNum();
		//List<String> list=new ArrayList();
		for(int i=0;i<rows;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<cells;j++)
			{
				Cell cel=row.getCell(j);
				switch(cel.getCellType())
				{
				case STRING:
					System.out.print(cel.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cel.getNumericCellValue());
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
	}

}
