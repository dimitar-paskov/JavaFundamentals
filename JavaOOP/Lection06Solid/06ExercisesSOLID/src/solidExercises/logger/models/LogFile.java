/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import solidExercises.logger.interfaces.File;

public class LogFile implements File {

	private static final String DEFAULT_PATH_AND_NAME = "output.txt";
	private StringBuilder text;
	private int size;
	private String filePathAndName;

	public LogFile() {
		this.text = new StringBuilder();
		this.size = 0;
		this.filePathAndName = DEFAULT_PATH_AND_NAME;
	}

	public LogFile(String filePathAndName) {
		this();
		this.filePathAndName = filePathAndName;
	}

	@Override
	public boolean write() {

		try {
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			Files.write(Paths.get(this.filePathAndName), this.text.toString().getBytes(), StandardOpenOption.APPEND);
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void setFilePathAndName(String filePathAndName) {
		this.filePathAndName = filePathAndName;
	}

	@Override
	public int getSize() {

		return this.calculateSize();
	}
	
	private int calculateSize() {
		
		int size = 0;
		
		for (char c : this.text.toString().toCharArray()) {
			
			if(Character.isAlphabetic(c)) {
				size += c;
			}
			
		}
		
		return size;
 
	}

	@Override
	public void append(String text) {
		this.text.append(text);

	}

}
