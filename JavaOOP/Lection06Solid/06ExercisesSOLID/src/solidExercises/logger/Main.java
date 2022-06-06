/**
 * @author dimitar
 *
 */
package solidExercises.logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import solidExercises.logger.controllers.EngineImpl;
import solidExercises.logger.controllers.InputParser;
import solidExercises.logger.factories.LoggerFactory;
import solidExercises.logger.interfaces.Engine;
import solidExercises.logger.interfaces.Factory;
import solidExercises.logger.interfaces.Logger;

public class Main {

	private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();
	private static  Engine engine;

	public static void main(String[] args) throws IOException {

		InputParser inputParser = new InputParser();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		engine = new EngineImpl(Main.LOGGER_FACTORY.produce(inputParser.readLoggerInfo(br)));
		engine.run("END", br);

		System.out.println(engine.toString());

//		Layout simpleLayout = new SimpleLayout();
//		Appender consoleAppender = new ConsoleAppender(simpleLayout);
//		Logger logger = new MessageLogger(consoleAppender);
//
//		logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//		logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
	}

}
