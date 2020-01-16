package csv;


import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import Topics.Topic;
import Topics.Topic_service;

@Service
public class CsvWriterService {

	@Autowired
	private Topic_service ts;
	
	static final String file="E:\\java_csv_file.csv";
	public void getCsv() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException  {
		try(
		Writer writer=Files.newBufferedWriter(Paths.get(file));)
		
		{
			StatefulBeanToCsv<Topic> beanToCsv=new StatefulBeanToCsvBuilder<Topic>(writer)
											.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
											.build();
			
			CSVWriter wr=new CSVWriter(writer,
					CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
			
			
			
			String[] header= {"id","field","description"};
			wr.writeNext(header);
			List<Topic> topic=ts.getAlltopic();
			beanToCsv.write(topic);
			wr.close();
			
		}
		
	}
	
	
}
