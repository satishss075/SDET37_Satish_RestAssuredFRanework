package Excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class excelUtility {
	
	public String getDataFromExcel(String SheetName, int rowNum, int celNum) throws Throwable
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/RestApi.xlsx"));
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cel);
		return value;
	}

}
