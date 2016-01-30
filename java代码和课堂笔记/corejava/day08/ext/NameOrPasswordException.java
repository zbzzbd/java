package day08.ext;
/**
 * 用户名或密码错
 * @author teacher
 *
 */
public class NameOrPasswordException extends Exception {

	public NameOrPasswordException(){
	}
	public NameOrPasswordException(String message){
		super(message);
	}
	public NameOrPasswordException(Throwable cause){
		super(cause);
	}
	public NameOrPasswordException(String message, Throwable cause){
		super(message, cause);
	}
}
