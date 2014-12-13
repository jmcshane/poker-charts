package mc.shane.poker.service.spreadsheet;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import mc.shane.poker.domain.Data;
import mc.shane.poker.domain.PokerResult;
import mc.shane.poker.service.SpreadsheetParser;

import org.apache.commons.lang3.StringUtils;

public class ApacheXLSXParser implements SpreadsheetParser {

	private static final int FIRST_DATA_COLUMN = 5;
	private static final int FIRST_PLAYER_ROW = 3;
	private Sheet sheet;
	
	private final int lastDataColumn;
	
	public ApacheXLSXParser(Workbook wb) {
		sheet = wb.getSheetAt(0);
		this.lastDataColumn = (int)sheet.getRow(0).getLastCellNum();
	}
	
	@Override
	public List<Data> getAllData() {
		return getNamesRow().stream()
			.map(entry -> createData(entry))
			.collect(Collectors.toList());
	}
	
	@Override
	public Data getPlayerData(String name) {
		Optional<Map.Entry<Integer,String>> nameOptional =
			getNamesRow().stream().parallel()
			.filter(e -> e.getValue().equals(name))
			.findFirst();
		if (nameOptional.isPresent()) {
			return createData(nameOptional.get());
		} else {
			throw new RuntimeException("Invalid name");
		}
	}
	
	private Data createData(Map.Entry<Integer, String> playerEntry) {
		List<PokerResult> data = IntStream.rangeClosed(FIRST_DATA_COLUMN, lastDataColumn).boxed()
			.<PokerResult>flatMap(index -> createPokerResult(index, playerEntry.getKey()))
			//reduction operation needed
			.collect(Collectors.<PokerResult, List<PokerResult>>reducing(Arrays.asList(new PokerResult(0, 0)), a -> Arrays.asList(a), operator()));
			//			.collect(Collectors.toList());
		return new Data(data, playerEntry.getValue());
	}
	
	private BinaryOperator<List<PokerResult>> operator() {
		return (a,b) -> {
			List<PokerResult> results = new ArrayList<>(a);
			System.out.println("A" + a);
			System.out.println("B" + b);
			System.out.println(b.get(0) instanceof PokerResult);
			results.add(b.get(0));
			results.get(results.size() -1).incrementY(a.get(a.size() - 1).getY());
			if (results.get(0).getX() == 0) { results.remove(0); }
			System.out.println(results);
			return results;
		};
	}
	private Stream<PokerResult> createPokerResult(Integer index, int playerIndex) {
		String entry = sheet.getRow(playerIndex).getCell(index).toString();
		if (StringUtils.isBlank(entry)) return Stream.of();
		try {
			return Stream.of(new PokerResult(index - FIRST_DATA_COLUMN + 1,Integer.parseInt(entry.substring(0, entry.length() - 2))));
		} catch (NumberFormatException e){
			return Stream.of();
		}
	}
	
	private List<Map.Entry<Integer, String>> getNamesRow() {
		return IntStream.rangeClosed(FIRST_PLAYER_ROW, sheet.getLastRowNum()).boxed()
			.map(index -> new AbstractMap.SimpleEntry<>(index, sheet.getRow(index).getCell(0).toString()))
			.filter(entry -> include(entry.getValue()))
			.collect(Collectors.toList());
	}
	
	private boolean include(String name) {
		if (StringUtils.isBlank(name)) return false;
		if ("Beer Fund".equals(name.trim())) return false;
		return true;
		
	}

	//Load all the rows on construction, get the rows with a call to get (int)
	//Use the keys of the names row and headers row to build the set of data
}
