package data.file.serialization.classes;

import java.io.File;
import java.io.IOException;

import org.ini4j.Wini;

public class DataICSerialization {
	
	private File file;
	private Wini winifile;
	
	public Wini getFile (String filepath) throws IOException {
		this.file = new File(filepath);
		this.file.createNewFile();
		this.winifile = new Wini(this.file.getAbsoluteFile());
		return this.winifile;
	}
	
	public void write(Wini winifile, String section, String key, String value) {
		try {
			winifile.put(section,key,value);
			winifile.put(section,key,value);
			winifile.store();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void read(Wini winifile, String section, String key) {
		if (winifile.get(section,key,String.class) == null ) {
			System.out.println("The following data weere not found:");
			System.out.println("[" + section + "]");
			System.out.println(section + ": " + key + "\n");
		} else {
			System.out.println("Data found successfully:");
			System.out.println("[" + section + "]");
			System.out.println(key + ": " + winifile.get(section, key) + "\n");
		}
	}
	
	public void delete(Wini winifile, String section) {
		try {
			winifile.remove(section);
			winifile.store();
		} catch (IOException e) {e.printStackTrace();}
	}

	public void drop() {
		this.file.delete();
	}
	
}
