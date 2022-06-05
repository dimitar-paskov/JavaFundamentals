/**
 * @author dimitar
 *
 */
package solidExercises.logger.controllers;

import java.util.Scanner;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Engine;
import solidExercises.logger.interfaces.Logger;

public class EngineImpl implements Engine {
	
	
	private Logger logger;
	private Scanner scanner;
	
	public EngineImpl(Logger logger) {
		this.logger = logger;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void run(String endString) {
		
		String input = scanner.nextLine();
		
		while(!input.equals(endString)) {
			
			String[] tokens = input.split("\\s+");
			
			ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
			String time = tokens[1];
			String message = tokens[2];
			
			this.logger.logCritical(time, message); 
			
			
			this.scanner.nextLine();
		}
		
	}

}
