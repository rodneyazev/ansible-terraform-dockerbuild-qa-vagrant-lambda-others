import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class DataJSONSerialization {

	public static void main(String[] args) throws IOException {
		
	
		DataJSONSerializationDAO dataSer = new DataJSONSerializationDAO();
		dataSer.setName("Rodney");
		dataSer.setSurname("Azevedo");
		ArrayList<String> listOfStates = new ArrayList<>();
		listOfStates.add("Brasil");
		listOfStates.add("Russia");
		listOfStates.add("South Africa");
		dataSer.setListOfStates(listOfStates);
		
		
		// Jackson
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writerr = mapper.writer(new DefaultPrettyPrinter());
		try {
			String json3 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataSer);
			writerr.writeValue(new File("datafileserialization.json"), dataSer);
			System.out.println(json3);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
