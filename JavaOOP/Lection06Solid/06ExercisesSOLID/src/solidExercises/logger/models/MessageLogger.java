/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Appender;
import solidExercises.logger.interfaces.Logger;

public class MessageLogger implements Logger {

	private Appender[] appenders;

	public MessageLogger(Appender... appenders) {
		this.appenders = appenders;
	}
	
	public void log(String time, String message, ReportLevel reportLevel) {
		this.logAll(time, message, reportLevel);
	}

	private void logAll(String time, String message, ReportLevel reportLevel) {
		for (Appender appender : appenders) {
			appender.append(time, message, reportLevel);
			if(appender instanceof FileAppender ) {
				
			}

		}
	}
//
//	@Override
//	public void logInfo(String time, String message) {
//
//		this.logAll(time, message, ReportLevel.INFO);
//
//	}
//
//	@Override
//	public void logWarning(String time, String message) {
//
//		this.logAll(time, message, ReportLevel.WARNING);
//
//	}
//
//	@Override
//	public void logError(String time, String message) {
//		this.logAll(time, message, ReportLevel.ERROR);
//	}
//
//	@Override
//	public void logCritical(String time, String message) {
//		this.logAll(time, message, ReportLevel.CRITICAL);
//	}
//
//	@Override
//	public void logFatal(String time, String message) {
//		this.logAll(time, message, ReportLevel.FATAL);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Logger info");

		for (Appender appender : appenders) {
			sb.append(System.lineSeparator());
			sb.append(appender.toString());
		}
		return sb.toString();
	}

}
