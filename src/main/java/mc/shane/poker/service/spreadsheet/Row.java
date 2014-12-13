package mc.shane.poker.service.spreadsheet;

public interface Row {
	int getLastCellNum();
	Cell getCell(int index);
}
