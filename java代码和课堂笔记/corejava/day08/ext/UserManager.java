package day08.ext;
import java.util.*;
public class UserManager {
	int idx = 1000;//用来产生用户id
	//使用Map对象存放用户，key=name，value=user
	Map<String, User> users 
		= new HashMap<String, User>();
	
	//使用Set对象保存用户的email
	Set<String> emailSet = new HashSet<String>();
	
	public User userRegist
	(String name, String password, String email)
	throws UserExistException, EmailUsedException{

		User u = users.get(name);//通过key找value
		//在用户集合中能找到此名字的用户
		if(u != null){
			throw new UserExistException("用户已存在！");
		}
		if(emailSet.contains(email)){
			throw new EmailUsedException("email已经使用过了！");
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
			throw new NameOrPasswordException("用户不存在！");
		}
		if (!u.getPassword().equals(password)){
			throw new NameOrPasswordException("密码错误！");
		}
		return u;
	}
}
