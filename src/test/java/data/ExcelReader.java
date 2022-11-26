package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream fis = null;
	
	public FileInputStream getfileinputstream() {
		String filepath = System.getProperty("user.dir") + "/src/test/java/data/userData.xlsx";
		File srcfile = new File(filepath);
		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: " +e.getMessage());
			System.exit(0);
		}
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException{
		fis = getfileinputstream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalnumberofrows = (sheet.getLastRowNum()+1);
		int totalnumberofcols = 4;
		
		String[][] arrayExcelData = new String[totalnumberofrows][totalnumberofcols];
		
		for (int i = 0; i < totalnumberofrows; i++) {
			for (int j = 0; j < totalnumberofcols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		
		return arrayExcelData;
		
	}
}
