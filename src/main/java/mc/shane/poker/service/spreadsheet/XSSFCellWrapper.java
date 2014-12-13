package mc.shane.poker.service.spreadsheet;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class XSSFCellWrapper implements Cell {
	
	private XSSFCell cell;
	
	public XSSFCellWrapper(XSSFCell cell) {
		this.cell = cell;
	}
	
	@Override
	public String toString() {
		if (cell == null) {
			return "";
		}
		return cell.toString();
	}
}
