package mc.shane.poker.service;

import java.util.List;

import mc.shane.poker.domain.Data;

public interface DataService {
	
	List<Data> getDataList();
	List<Data> getPlayerData(String name);

}
