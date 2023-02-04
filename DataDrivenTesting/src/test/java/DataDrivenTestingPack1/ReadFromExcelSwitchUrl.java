package DataDrivenTestingPack1;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelSwitchUrl 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("skill");
		int rows=sh.getLastRowNum();
		int cells=sh.getRow(0).getLastCellNum();
		//List list=new ArrayList();
	//	Map m=new HashMap();
		for(int i=0;i<rows;i++) 
		{
			
			Row row=sh.getRow(i);
			for(int j=0;j<cells;j++)
			{
				Cell cell=row.getCell(j);
				switch(cell.getCellType())
				{
				case STRING:
						System.out.print(cell.getStringCellValue());
						break;
				case NUMERIC:
						 System.out.print(cell.getNumericCellValue());
						break;
				}
				System.out.print(" ");
			}
			System.out.println();
			
			
		}
		
		


	}

}
