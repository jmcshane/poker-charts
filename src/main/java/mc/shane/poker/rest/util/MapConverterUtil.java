package mc.shane.poker.rest.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import mc.shane.poker.domain.Data;
import mc.shane.poker.domain.PokerResult;

public class MapConverterUtil {
	
	private MapConverterUtil() {
		
	}
	
	public static List<Map<String,Object>> convertToMap(List<Data> input) {
		return input.stream().map(dataObj -> {
			Map<String,Object> map = new HashMap<>();
			map.put("name", dataObj.getName());
			map.put("data", getDataList(dataObj.getData()));
			return map;
		}).collect(Collectors.toList());
	}
	
	private static List<Map<String, Object>> getDataList(List<PokerResult> data) {
		return data.stream().map(input -> {
			Map<String,Object> map = new HashMap<>();
			map.put("x", input.getX());
			map.put("y", input.getY());
			return map;
		}).collect(Collectors.toList());
	}

}
