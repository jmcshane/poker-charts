package mc.shane.poker.service.spreadsheet;

import java.util.Arrays;
import java.util.List;

import mc.shane.poker.domain.Data;
import mc.shane.poker.service.DataService;
import mc.shane.poker.service.SpreadsheetParser;

public class SpreadsheetDataService implements DataService{
	
	private final SpreadsheetParser parser;
	
	public SpreadsheetDataService(SpreadsheetParser parser) {
		this.parser = parser;
	}
		
	public List<Data> getDataList() {
		return parser.getAllData();
	}
	
	public List<Data> getPlayerData(String name) {
		return Arrays.asList(parser.getPlayerData(name));
	}

}
