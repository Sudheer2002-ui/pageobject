package Excel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
public class xldata {
	public static String[][] readExcel(int sheet) throws Exception {
		String[][] testData = null;
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(sheet); 
		testData = new String[1][3];
		for (int i = 0; i <= ws.getLastRowNum(); i++) {
			Row r = ws.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				testData[i][j] = String.valueOf(ws.getRow(i).getCell(j));
			}
		}
		wb.close();
				return testData;
	}
}