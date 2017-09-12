package eBizOrdering;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlReader  {
public static String path = "C:\\Selenium Jar\\TestData.xlsx";
public static void getAllExcelData(int SheetNo) throws IOException
{
	
		File file = new File(path);
	    FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheetAt(SheetNo);
        int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
        for(int i=0; i<=rowCount; i++)
	   
      {
	   Row rw = sh.getRow(i);
	   for(int j=0;j<rw.getLastCellNum();j++)
	   {
		   System.out.println(rw.getCell(j).getStringCellValue());
	   }
   }
   fis.close();
   wb.close();
	
}

public static String getExcelDataSheetNo(int sheetNo, int rowNum,int colNum) throws IOException, EncryptedDocumentException, InvalidFormatException
{

		File file = new File(path);
	    FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheetAt(sheetNo);
        Row rw = sh.getRow(rowNum);
        Cell cell= rw.getCell(colNum);
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
        {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        String data = cell.getStringCellValue();
        return data; 
}

public static String getExcelDataSheetName(String sheetName, int rowNum,int colNum) throws IOException, EncryptedDocumentException, InvalidFormatException
{

		File file = new File(path);
	    FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row rw = sh.getRow(rowNum);
        Cell cell= rw.getCell(colNum);
        String data = cell.getStringCellValue();
        return data; 
}

public static int rowCountSheetNo(int sheetNo) throws IOException
{
	File file = new File(path);
    FileInputStream fis = new FileInputStream(file);
	Workbook wb =new  XSSFWorkbook(fis);
	Sheet sh = wb.getSheetAt(sheetNo);
	int rowCount = sh.getLastRowNum();
	return rowCount+1;
}

public static int rowCountSheetName(String sheetName) throws IOException
{
	File file = new File(path);
    FileInputStream fis = new FileInputStream(file);
	Workbook wb =new  XSSFWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int rowCount = sh.getLastRowNum();
	return rowCount+1;
}

public static void setExclData(String sheetName , int rowNum , int colNum , String stringData) throws IOException
{
	File file = new File(path);
    FileInputStream fis = new FileInputStream(file);
	Workbook wb =new  XSSFWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
    Row rw = sh.getRow(rowNum);
    Cell cell= rw.getCell(colNum);
    cell.setCellType(cell.CELL_TYPE_STRING);
    cell.setCellValue(stringData);
    FileOutputStream fos = new FileOutputStream(path);
    wb.write(fos);
}





}

   
      
