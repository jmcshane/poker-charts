package mc.shane.poker.service;

import java.util.List;

import mc.shane.poker.domain.Data;

public interface SpreadsheetParser {
	
	List<Data> getAllData();
	
	Data getPlayerData(String name);

}
