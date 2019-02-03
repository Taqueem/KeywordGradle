package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtil {

	Workbook		workbook;

	Sheet			sheet;

	Row				row;

	Cell			cell;

	DataFormatter	dataformat	= new DataFormatter();

	public Workbook createWorkBook(String filePath) {

		try {
			FileInputStream ExcelFile = new FileInputStream(filePath);
			// workbook = WorkbookFactory.create(new File(filePath));
			workbook = WorkbookFactory.create(ExcelFile);
			System.out.println("Created workbook");
		} catch (EncryptedDocumentException | IOException e) {
			System.out.println("Exception in creating the workbook");
			e.printStackTrace();
		}
		return workbook;
	}

	public Sheet setSheet(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	public String getCellData(int rowNum, int colNum) {

		cell = sheet.getRow(rowNum).getCell(colNum);
		String cellValue = dataformat.formatCellValue(cell);
		// System.out.println(cellValue);
		return cellValue;
	}

	public int noOfNotEmptyCellsinColumn(int colNum) {

		int numberofCells = 0;
		try {
			int lastRow = sheet.getLastRowNum();
			System.out.println("Last row num = " + lastRow);
			for (int i = 1; i < lastRow; i++) {
				String cellValue = getCellData(i, colNum);
				if (!(cellValue.isEmpty())) {
					numberofCells++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return numberofCells;
	}

	public HashMap<Integer, String> getTestCaseMap(int colNum) {

		HashMap<Integer, String> testcaseMap = new HashMap<Integer, String>();
		int lastRow = sheet.getLastRowNum();
		for (int i = 1; i < lastRow; i++) {
			String cellValue = getCellData(i, colNum);
			if (!cellValue.isEmpty()) {
				testcaseMap.put(i + 1, cellValue);
			}
		}
		return testcaseMap;
	}

	public Object[][] getTestCasesName() {

		int noTestCases = noOfNotEmptyCellsinColumn(TestCaseMapper.TestCase);
		int numberOfParameter = 1;
		Object[][] testCases = new Object[noTestCases][numberOfParameter];
		int lastRow = sheet.getLastRowNum();
		int ci = 0, cj = 0;
		for (int i = 1; i < lastRow; i++, ci++) {
			String cellValue = getCellData(i, TestCaseMapper.TestCase);
			if (!cellValue.isEmpty()) {
				testCases[ci][cj] = i;
			}
		}
		return testCases;
	}
}
