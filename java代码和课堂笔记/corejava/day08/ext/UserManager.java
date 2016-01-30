package day08.ext;
import java.util.*;
public class UserManager {
	int idx = 1000;//���������û�id
	//ʹ��Map�������û���key=name��value=user
	Map<String, User> users 
		= new HashMap<String, User>();
	
	//ʹ��Set���󱣴��û���email
	Set<String> emailSet = new HashSet<String>();
	
	public User userRegist
	(String name, String password, String email)
	throws UserExistException, EmailUsedException{

		User u = users.get(name);//ͨ��key��value
		//���û����������ҵ������ֵ��û�
		if(u != null){
			throw new UserExistException("�û��Ѵ��ڣ�");
		}
		if(emailSet.contains(email)){
			throw new EmailUsedException("email�Ѿ�ʹ�ù��ˣ�");
		}
		User user = new User(idx++, name, password, email);
		users.put(name, user);
		emailSet.add(email);
		return user;
	}
	public User userLogin(String name, String password)
    throws NameOrPasswordException{
		User u = users.get(name);
		if (u == null){
			throw new NameOrPasswordException("�û������ڣ�");
		}
		if (!u.getPassword().equals(password)){
			throw new NameOrPasswordException("�������");
		}
		return u;
	}
}
