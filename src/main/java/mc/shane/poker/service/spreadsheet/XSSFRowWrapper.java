package mc.shane.poker.service.spreadsheet;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class XSSFRowWrapper implements Row {

	private XSSFRow row;
	
	public XSSFRowWrapper(XSSFRow row) {
		this.row = row;
	}
	
	@Override
	public int getLastCellNum() {
		return row.getLastCellNum();
	}

	@Override
	public Cell getCell(int index) {
		return new XSSFCellWrapper(row.getCell(index));
	}

}
