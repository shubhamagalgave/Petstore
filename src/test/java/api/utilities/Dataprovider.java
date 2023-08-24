package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class Dataprovider {
	
	@DataProvider
	public String[][] getAllData() throws IOException
	{
		
		String path="E:\\Acceleration\\Automation Testing\\Workplace 4.9\\PetstoreAutomation\\TestData\\APITestData.xlsx";
		XLUtils x1=new XLUtils();
		
		int rownum=x1.getRowCount(path, "Sheet1");
		int colcount=x1.getCellCount(path, "Sheet1", 1);
		
		String data[][]=new String[rownum][colcount];
		
		for (int i =1; i <=rownum; i++)
		{
			for (int j = 0; j <colcount; j++) 
			{
				data[i-1][j]=x1.getCellData(path,"Sheet1",i,j);
			}
		}
		return data;
	}
	
	
	//----------------------------------------------------****----------------------------------------------------------------
	
	
	@DataProvider
	public String[] getUsername() throws IOException
	{
		
		String path="E:\\Acceleration\\Automation Testing\\Workplace 4.9\\PetstoreAutomation\\TestData\\APITestData.xlsx";
		XLUtils x1=new XLUtils();
		
		int rownum=x1.getRowCount(path, "Sheet1");
		
		
		String data[]=new String[rownum];
		
		for (int i =1; i <=rownum; i++)
		{
				data[i-1]=x1.getCellData(path,"Sheet1",i,1);
			
		}
		return data;
	}


	
}
