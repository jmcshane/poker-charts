package mc.shane.poker.service.spreadsheet;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class XSSFSheetWrapper implements Sheet {

	private XSSFSheet sheet;
	
	public XSSFSheetWrapper(XSSFSheet sheet) {
		this.sheet = sheet;
	}
	
	@Override
	public Row getRow(int row) {
		return new XSSFRowWrapper(sheet.getRow(row));
	}

	@Override
	public int getLastRowNum() {
		return sheet.getLastRowNum();
	}

}
