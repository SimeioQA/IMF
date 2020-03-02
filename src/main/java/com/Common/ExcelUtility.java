package com.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public ArrayList<HashMap<String, String>> readExcel(String Path) throws IOException
	{
		HashMap<String, String> map ;
		ArrayList<HashMap<String, String>>  list = new ArrayList<HashMap<String,String>>();
		
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFile); 
			/*XSSFSheet sheet=wb.getSheet("User Data");*/ /*NAM*/
			/*XSSFSheet sheet=wb.getSheet("User Data SEPCO");*//*SEPCO*/
			XSSFSheet sheet=wb.getSheet("User Data WF");/*Work Flow*/
			
			int rowCount=sheet.getLastRowNum()+1;
			int colCount=sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
			
			for(int i=1;i<rowCount;i++)
			{
				XSSFRow row=sheet.getRow(i);
				map = new HashMap<String, String>();
			for (int j=0;j<colCount;j++)
			{
				if(row!=null)
				{				
					map.put(sheet.getRow(0).getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
				}
								
			}
			
			list.add(map);
						
			}
			
		}

		catch (Exception e) {
		
			e.printStackTrace();
		}
		return list;
	}

/*public static void setExcelFile(String Path,String Sheetname)
{
	try {
		FileInputStream ExcelFile = new FileInputStream(Path);
		File outputSheet=new File(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet("Sheet1");
		if(outputSheet.exists())
		{
			System.out.println("Output sheet Exists");
		}
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	}*/
	
	/*public static boolean isRowEmpty(Row row){
        for(int c = row.getFirstCellNum(); c<row.getLastCellNum();c++){
            Cell cell = row.getCell(c);
            if(cell!=null && cell.getCellType()!=Cell.CELL_TYPE_BLANK){
                return false;
            }
        }
        return true;
   }
*/
public static void writeExcel(String Path,ArrayList<HashMap<String, String>> outputList) throws IOException
{
	FileInputStream ExcelFile = new FileInputStream(Path);
	File outputSheet=new File(Path);
	XSSFWorkbook wb = new XSSFWorkbook(ExcelFile);
	XSSFSheet sheet = wb.getSheet("Sheet1");
	if(outputSheet.exists())
	{
	int i = 1;
	XSSFRow row = null;
	
	for(HashMap<String, String> output:outputList)
	{
		
		//if(isRowEmpty(row)==false){
	    row = sheet.createRow(i);
		XSSFCell  cell ;
		for(int col=0;col<sheet.getRow(0).getLastCellNum();col++)
		{
		cell = row.createCell(col);
		cell.setCellValue(output.get(sheet.getRow(0).getCell(col).getStringCellValue()));
		}
		i++;			
	}
	}
	//}
	FileOutputStream fileOut = new FileOutputStream(Path);
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();

}
}
