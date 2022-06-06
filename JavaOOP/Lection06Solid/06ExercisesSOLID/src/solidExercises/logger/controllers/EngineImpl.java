/**
 * @author dimitar
 *
 */
package solidExercises.logger.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Engine;
import solidExercises.logger.interfaces.Logger;

public class EngineImpl implements Engine {
	
	
	private Logger logger;
	
	public EngineImpl(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void run(String endString, BufferedReader br) throws IOException { 
		
		String input = br.readLine();
		
		while(!input.equals(endString)) {
			
			String[] tokens = input.split("\\|");
			
//			ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
			String time = tokens[1];
			String message = tokens[2];
			
			this.logger.log(time, message,ReportLevel.valueOf(tokens[0])); 
			
			
			input = br.readLine();
		}
		
		
	}

	@Override
	public String toString() {
		return this.logger.toString();
	}
	
	

}
