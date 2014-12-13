package mc.shane.poker.service.spreadsheet

import mc.shane.poker.domain.Data
import mc.shane.poker.domain.PokerResult


import spock.lang.Specification

class ApacheXLSXParserSpec extends Specification {
	
	ApacheXLSXParser parser;
	Workbook wb = Mock();
	Sheet sheet = Mock();
	Row row = Mock();
	def setup() {
		1*row.getLastCellNum() >> 6
		1*wb.getSheetAt(0) >> sheet
		1*sheet.getRow(0) >> row
		parser = new ApacheXLSXParser(wb)
	}
	
	def 'getPlayerData should create the list of data'() {
		given:
		sheet.getLastRowNum() >> 4
		sheet.getRow(3) >> row
		Row secondRow = Mock();
		sheet.getRow(4) >> secondRow
		Cell p1Cell = Mock()
		Cell p2Cell = Mock()
		row.getCell(0) >>  p1Cell
		secondRow.getCell(0) >> p2Cell
		p1Cell.toString() >> "Mike"
		p2Cell.toString() >> "Bill"
		Cell c35 = Mock()
		Cell c36 = Mock()
		Cell c45 = Mock()
		Cell c46 = Mock()
		row.getCell(5) >> c35
		row.getCell(6) >> c36
		secondRow.getCell(5) >> c45
		secondRow.getCell(6) >> c46
		c35.toString() >> ""
		c36.toString() >> "5"
		c45.toString() >> "-2"
		c46.toString() >> "0"
		expect:
		parser.getPlayerData("Mike").toString() == 
			(new Data([new PokerResult(2, 5)], "Mike")).toString()
		parser.getPlayerData("Bill") ==
			new Data([new PokerResult(1, -2), new PokerResult(2, 0)], "Bill")
		parser.getAllData() ==
			[new Data([new PokerResult(2, 5)], "Mike"),
			new Data([new PokerResult(1, -2), new PokerResult(2, 0)], "Bill")]
	}
}
