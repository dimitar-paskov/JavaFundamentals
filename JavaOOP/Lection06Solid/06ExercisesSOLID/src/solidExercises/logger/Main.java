/**
 * @author dimitar
 *
 */
package solidExercises.logger;

import solidExercises.logger.controllers.InputParser;
import solidExercises.logger.factories.LoggerFactory;
import solidExercises.logger.interfaces.Factory;
import solidExercises.logger.interfaces.Logger;

public class Main {
	
	private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();

	public static void main(String[] args) {
		
		InputParser inputParser = new InputParser();
		
		Logger logger = LOGGER_FACTORY.produce(inputParser.readLoggerInfo());
		
		
		
		System.out.println();
		

//		Layout simpleLayout = new SimpleLayout();
//		Appender consoleAppender = new ConsoleAppender(simpleLayout);
//		Logger logger = new MessageLogger(consoleAppender);
//
//		logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//		logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
	}

}
