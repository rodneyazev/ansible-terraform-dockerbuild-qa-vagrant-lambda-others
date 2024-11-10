package data.file.serialization.app;

import java.io.IOException;

import org.ini4j.Wini;

import data.file.serialization.classes.DataICSerialization;

public class DataICSerializationApp {

	public static void main(String[] args) throws IOException {
		
		DataICSerialization icFile = new DataICSerialization();
		Wini winiFile = icFile.getFile("datafileserialization.ini");
		
		icFile.write(winiFile, "Language", "Java", "Java Runtime Environment");
		icFile.write(winiFile, "Database", "Version", "1.8");
		
		icFile.write(winiFile, "Kindred", "Function", "Jungle");
		icFile.write(winiFile, "Kindred", "Release", "2015");
		
		icFile.read(winiFile, "Language", "C++");		
		icFile.read(winiFile, "Kindred", "Function");
		icFile.read(winiFile, "Kindred", "Release");
		
		icFile.delete(winiFile, "Database");
		// ic.drop();
		
	}

}
