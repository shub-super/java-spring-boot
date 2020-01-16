package csv;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@RestController
public class CsvWriterHandler {

	@Autowired
	CsvWriterService service;
	
	
	@GetMapping("/topic_csv")
	public String getCsv_handler() throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		service.getCsv();
		return "home.jsp";
	}
	
	
	
	
}
