package javase1.day05.exp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/** �Զ����쳣ʹ�ð���: */
public class ExceptionDemo3 {
  public static void main(String[] args) {
    AccountManager mgr = new AccountManager();
    Scanner in = new Scanner(System.in);
    while(true){
      System.out.println("1 ע��, 2 ��¼, 0 �˳�");
      String cmd = in.nextLine();
      if(cmd.equals("1")){
        reg(in, mgr);
      }else if(cmd.equals("2")){
        login(in, mgr);
      }else if(cmd.equals("0")){
        break;
      }
    }
  }

  private static void login(
      Scanner in, AccountManager mgr) {
    int count = 0;
    while(true){
      System.out.print("����(email pwd):");
      String str = in.nextLine();
      String[] data = str.split("\\s+");
      String email = data[0];
      String pwd = data[1];
      try {
        User one = mgr.login(email, pwd);
        System.out.println("���û�:"+one);
        break;
      } catch (EmailOrPwdException e) {
        e.printStackTrace();
        //�����쳣�߼�...
        count++;
        if(count==3){
          break;
        }
      }
    }
  }

  private static void reg(
      Scanner in, AccountManager mgr) {
    while(true){
      System.out.print("����(email pwd):");
      String str = in.nextLine();
      String[] data = str.split("\\s+");
      String email = data[0];
      String pwd = data[1];
      try {
        User one = mgr.reg(email, pwd);
        System.out.println("���û�:"+one);
        break;
      } catch (UserExistException e) {
        e.printStackTrace();
        //�����쳣�߼�...
      }
    }
  }
}
class AccountManager{
  private Map<String, User> users = 
    new HashMap<String, User>();
  private int id = 1;
  /**
   * ע�Ṧ��
   * @param email
   * @param pwd
   * @return ע��ɹ������û�
   * @throws UserExistException �û��Ѿ�ע�����
   * (email�ظ�) UserExistException�Զ����ҵ��(����)�쳣
   * �쳣�����Ĺؼ���: throws
   */
  public User reg(String email, String pwd) 
    throws UserExistException{
    User u = users.get(email);
    if(u!=null){
      //����ҵ����Ҫʹ��throw�׳��쳣
      throw new UserExistException("�û��Ѿ�����!");
    }
    u = new User(id++, email, pwd);
    users.put(email, u);
    return u;
  }
  public User login(String email, String pwd) 
    throws EmailOrPwdException{
    User u = users.get(email);
    if(u==null){
      throw new EmailOrPwdException("û���û�!");
    }
    if(u.getPwd().equals(pwd)){
      return u;
    }
    throw new EmailOrPwdException("�������!");
  }
}
/** �Զ����쳣Ҫ һ��Ҫ�ֶ��̳�ȫ���ĸ��๹���� */
class EmailOrPwdException extends Exception{
  public EmailOrPwdException() {
    super();
  }
  public EmailOrPwdException(String message, Throwable cause) {
    super(message, cause);
  }
  public EmailOrPwdException(String message) {
    super(message);
  }
  public EmailOrPwdException(Throwable cause) {
    super(cause);
  }
}
/** �Զ����쳣Ҫ һ��Ҫ�ֶ��̳�ȫ���ĸ��๹���� */
class UserExistException extends Exception{
  public UserExistException() {
    super();
  }
  public UserExistException(String message, Throwable cause) {
    super(message, cause);
  }
  public UserExistException(String message) {
    super(message);
  }
  public UserExistException(Throwable cause) {
    super(cause);
  }
}

class User{
  private int id;
  private String email;
  private String pwd;
  private long lastLogin;
  public User() {
  }
  public User(int id, String email, String pwd) {
    super();
    this.id = id;
    this.email = email;
    this.pwd = pwd;
  }
  public long getLastLogin() {
    return lastLogin;
  }
  public void setLastLogin(long lastLogin) {
    this.lastLogin = lastLogin;
  }
  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  @Override
  public String toString() {
    return id+":"+email;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj==null){
      return false;
    }
    if(this==obj){
      return true;
    }
    if (obj instanceof User) {
      User u = (User) obj;
      return this.id==u.id;
    }
    return false;
  }
  @Override
  public int hashCode() {
    return id;
  }
}




