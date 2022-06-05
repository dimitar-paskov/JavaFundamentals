/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.File;
import solidExercises.logger.interfaces.Layout;

public class FileAppender extends AppenderImpl {

	private File file;

	public FileAppender(Layout layout) {
		super(layout);
		this.file = new LogFile();

	}

	public FileAppender(Layout layout, ReportLevel reportLevel) {
		super(layout, reportLevel);
		this.file = new LogFile();
	}

	@Override
	public void append(String time, String message, ReportLevel reportLevel) {
		
		super.increaseMessagesCount();
		
		if (this.file == null) {
			throw new IllegalCallerException("File not set");
		}

		if (this.canAppend(reportLevel)) {
			file.append(this.getLayout().format(time, message, reportLevel));
		}

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return super.toString() + ", File size: " + this.file.getSize();
	}
	
	

}
