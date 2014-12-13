package mc.shane.poker.rest;

import java.util.List;
import java.util.Map;

import mc.shane.poker.rest.util.MapConverterUtil;
import mc.shane.poker.service.spreadsheet.SpreadsheetDataService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data")
public class DataRestService {
	private final SpreadsheetDataService service;

	public DataRestService(SpreadsheetDataService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Map<String,Object>> getDataInJson() {
		return MapConverterUtil.convertToMap(service.getDataList());
	}
	
	@RequestMapping(value = "/test", produces = "text/plain", method = RequestMethod.GET)
	public String getGreeting() {
		return "Hi";
	}
	
	@RequestMapping(value = "/player", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Map<String,Object>> getPlayerData(String... params) {
		if (params.length == 0) {
			return null;
		}
		return MapConverterUtil.convertToMap(service.getPlayerData(params[0]));
	}

	 
}
