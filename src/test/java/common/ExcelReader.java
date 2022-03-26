package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader {

	public static Object[] getExcelData(String tdFileName, String tdSheetName) {
		Object object[] = null;
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(tdFileName));

			HSSFSheet sheet = workbook.getSheet(tdSheetName);

			int totalRows = sheet.getPhysicalNumberOfRows();

			System.out.println("totalRows: " + totalRows);

			object = new Object[totalRows - 1];

			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

			System.out.println("totalColumns: " + totalColumns);

			for (int rowCounter = 1; rowCounter < totalRows; rowCounter++) {
				HashMap<String, String> rowMap = new HashMap<String, String>();

				HSSFRow headRow = sheet.getRow(0);
				HSSFRow row = sheet.getRow(rowCounter);
				for (int columnCounter = 0; columnCounter < totalColumns; columnCounter++) {
					HSSFCell cell = row.getCell(columnCounter);
					HSSFCell cellHeader = headRow.getCell(columnCounter);
					String cellData = cell.getStringCellValue();
					String cellDataHeader = cellHeader.getStringCellValue();
					System.out.println(cellDataHeader + ": " + cellData);
					rowMap.put(cellDataHeader, cellData);
				}
				object[rowCounter - 1] = rowMap;
			}

		} catch (IOException e) {
			Reporter.log("excel data accessing, exception occured", true);
			e.printStackTrace();
		}

		return object;
	}

}
