package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConf {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	
	public ExcelDataConf(String excelpath) throws Exception
	
	{
		
		try {
			File src = new File(excelpath);
			
			FileInputStream fls = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fls);
			
			//sheet1 = wb.getSheetAt(0);
		 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public String getData(int sheetnumber,int row,int col)	
	{
		sheet1 = wb.getSheetAt(0);
		
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
