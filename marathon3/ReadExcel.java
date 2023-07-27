package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData(String fileName) throws IOException {
	     
			XSSFWorkbook wb = new XSSFWorkbook("data/SalesForce.xlsx");
			XSSFSheet ws = wb.getSheet(fileName);
			int rowCount = ws.getLastRowNum(); 
			short columnCount = ws.getRow(0).getLastCellNum();
			String [][] data=new String[rowCount][columnCount];
			
			for (int i = 1; i <=rowCount; i++) {//0 1 2
				XSSFRow row = ws.getRow(i);	
				
				for(int j=0;j<columnCount;j++) {
					XSSFCell cell = row.getCell(j);
					
					String value = cell.getStringCellValue();
					data[i-1][j]=cell.getStringCellValue();
					System.out.println(value);
				}
			}
			
							wb.close();
							return data;
}


}
