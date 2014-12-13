package mc.shane.poker.service.spreadsheet;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFWorkbookWrapper implements Workbook {
	
	private XSSFWorkbook wb;
	
	@SuppressWarnings("deprecation")
	public XSSFWorkbookWrapper(String filePath) {
		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			throw new RuntimeException("InvalidFile");
		}
	}

	@Override
	public Sheet getSheetAt(int sheetNum) {
		return new XSSFSheetWrapper(wb.getSheetAt(sheetNum));
	}

}
