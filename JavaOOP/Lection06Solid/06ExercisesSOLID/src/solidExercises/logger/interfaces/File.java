/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

public interface File {
	
	boolean write();
	int getSize();
	void append(String text);

}
