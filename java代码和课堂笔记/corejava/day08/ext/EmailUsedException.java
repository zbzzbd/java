package day08.ext;
/**
 * email�Ѿ���ʹ���쳣
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
