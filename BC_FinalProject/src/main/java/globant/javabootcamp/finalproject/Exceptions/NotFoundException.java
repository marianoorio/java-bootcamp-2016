package globant.javabootcamp.finalproject.Exceptions;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class NotFoundException extends Exception{

	/**
	 *  Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = 2809759577129753830L;
	
	public NotFoundException(){
	     super("User not found");
	  }
}
