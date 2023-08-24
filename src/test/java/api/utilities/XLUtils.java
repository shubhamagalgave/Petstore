package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook work;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException{
		fi=new FileInputStream(xlfile);
		work=new XSSFWorkbook(fi);
		sheet=work.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		work.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		work=new XSSFWorkbook(fi);
		sheet=work.getSheet(xlsheet);
	    row=sheet.getRow(rownum);
	    int cellcount=row.getLastCellNum();
		work.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		work=new XSSFWorkbook(fi);
		sheet=work.getSheet(xlsheet);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(colnum);
	    String data;
	    
	    try {
	    DataFormatter formatter = new DataFormatter();
	    String cellData=formatter.formatCellValue(cell);
	    return cellData;
	    }catch (Exception e) {
	    	data="";
		}
	    
	    work.close();
		fi.close();
		return data;
	}

	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		work=new XSSFWorkbook(fi);
		sheet=work.getSheet(xlsheet);
	    row=sheet.getRow(rownum);
	    cell=row.getCell(colnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(xlfile);
	    work.write(fo);
	   
	    work.close();
		fi.close();
		fo.close();
	}


}
