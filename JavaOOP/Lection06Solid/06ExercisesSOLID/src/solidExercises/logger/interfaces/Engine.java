/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {

	void run(String endString, BufferedReader br) throws IOException;  
} 
