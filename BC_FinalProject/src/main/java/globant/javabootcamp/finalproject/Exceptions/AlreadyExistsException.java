package globant.javabootcamp.finalproject.Exceptions;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class AlreadyExistsException extends Exception{
	
	/**
	 * Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = -6205651461177822920L;

	public AlreadyExistsException(){
	     super("User Already exists");
	  }
}
