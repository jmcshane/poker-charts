package mc.shane.poker.service.spreadsheet;

public interface Sheet {
	
	Row getRow(int row);
	
	int getLastRowNum();

}
