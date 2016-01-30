package day08.ext;
/**
 * email已经被使用异常
 * @author teacher
 *
 */
public class EmailUsedException extends Exception {

	public EmailUsedException(){
	}
	public EmailUsedException(String message){
		super(message);
	}
	public EmailUsedException(Throwable cause){
		super(cause);
	}
	public EmailUsedException(String message, Throwable cause){
		super(message, cause);
	}
}
