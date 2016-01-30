package day08;

import java.util.*;

public class AccountManagerImpl  
  implements AccountManager{
  //map �� key���û���, value��Userʵ��
  private Map<String, User> users = 
    new HashMap<String, User>();
  
  private int idx=1;

  public User[] findAll() {
    Collection<User> all = users.values();
    return all.toArray(new User[0]); 
  }

  public User[] findByEmail(String email) {
    ArrayList<User> list = 
      new ArrayList<User>();
    Set<String> names = users.keySet();
    Iterator<String> i = names.iterator();
    while(i.hasNext()){
      String name = i.next();
      User u = users.get(name);
      //"liucangsong@gmail.com".indexOf("cang") 
      if(u.getEmail().indexOf(email)>=0){
        list.add(u);
      }
    }
    return list.toArray(new User[]{}); 
  }

  public User findById(int id) {
    Collection<User> all = users.values();
    Iterator<User> i = all.iterator();
    //������User����
    while (i.hasNext()) {
      User u = i.next();
      if(u.getId()==id){
        return u;
      }
    }
    return null;
  }

  public User findByName(String name) {
    return users.get(name);
  }

  public User login(String name, String pwd) {
    User u = users.get(name);
    if(u==null)
      throw new IllegalArgumentException("������");
    if(!u.getPwd().equals(pwd))
      throw new IllegalArgumentException("�����");
    return u;
  }

  public User reg(String name,
      String pwd, String email) {
    if(users.containsKey(name)){
      throw new IllegalArgumentException("�Ѿ�ע��");
    }
    User user = new User(idx++, name,pwd);
    user.setEmail(email);
    users.put(name, user);
    return user;
  }

  public void updatePassword(int id, String password) {
    User u = findById(id);
    u.setPwd(password);
  }

     
}
