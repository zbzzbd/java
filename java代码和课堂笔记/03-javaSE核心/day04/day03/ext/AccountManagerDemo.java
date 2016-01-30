package javase1.day03.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/** 
 * �ʺŵ�¼�����ԭ�� 
 */
public class AccountManagerDemo {
  public static void main(String[] args) {
    AccountManager mgr = new AccountManager();
    Scanner console = new Scanner(System.in);
    while(true){
      System.out.print("1 ע��, 2 ��¼, " +
          "3 ȫ��, 4 ��ѯ, 5 ɾ��, 0 �뿪:");
      String cmd = console.nextLine();
      if(cmd.equals("1")){
        reg(mgr, console);
      }else if(cmd.equals("2")){
        login(mgr, console);
      }else if(cmd.equals("3")){
        listAll(mgr, console);
      }else if(cmd.equals("4")){
        find(mgr, console);
      }else if(cmd.equals("5")){
        delete(mgr, console);
      }else if(cmd.equals("0")){
        System.out.println("��, 88!");
        break;
      }
    }
  }
  public static void login(AccountManager mgr,Scanner s){
    String str;
    while(true){
      System.out.print("����email������(email pwd):");
      str = s.nextLine();
      if(str.matches("^.+\\s+\\w+$")){
        break; 
      }
      System.out.println("��ʽ����");
    }
    String[] data = str.split("\\s+");
    String email = data[0]; String pwd = data[1];
    User newone = mgr.login(email, pwd);
    System.out.println("��ӭ"+newone+"����!"); 
  }
  public static void listAll(AccountManager mgr,Scanner s){
    List<User> all = mgr.findAll();
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+u);  
    }
  }
  public static void find(AccountManager mgr,Scanner s){
    System.out.print("�����û���:");
    String name = s.nextLine();
    List<User> all = mgr.findByName(name);
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+u); 
    }
  }
  public static void delete(AccountManager mgr,Scanner s){
    System.out.println("ѡ���ĸ�Ҫɾ��:");
    int index = 0;
    List<User> all = mgr.findAll();
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+(index++)+":"+u);  
    }
    System.out.print("���:");
    index = s.nextInt();
    User u = all.get(index);
    mgr.remove(u);
    System.out.println("�ɹ�ɾ��:"+u); 
  }
  public static void reg(AccountManager mgr,Scanner s){
    String str;
    while(true){
      System.out.print("����email������(email pwd):");
      str = s.nextLine();
      if(str.matches("^.+\\s+\\w+$")){
        break; 
      }
      System.out.println("��ʽ����");
    }
    String[] data = str.split("\\s+");
    String email = data[0]; String pwd = data[1];
    User newone = mgr.reg(email, pwd);
    System.out.println("��ϲ"+newone+"�ɹ�ע��!"); 
  }
}
/** �˻��Ĺ���(��ɾ�Ĳ�)���� */
class AccountManager{
  /** users��map���ϴ洢��¼�û�,key��email, ���ظ�,
   * value��User���� */
  private HashMap<String, User> users = 
    new HashMap<String, User>();
  /** id �����û���� */
  private int id = 1;
  /** ע���û�: ǰ�������email��pwd,�����ע��ɹ����û����� */
  public User reg(String email, String pwd){
    //User u = users.get(email);//�Ȳ�ѯ�����û�
    //if(u!=null){//������û������쳣, ��ǰ������ǰ����
    //  throw new RuntimeException("�û��Ѿ�ע��!");
    //}
    if(users.containsKey(email)){
      throw new RuntimeException("�û��Ѿ�ע��!");
    }
    User u = new User(id++, email, pwd);
    users.put(email, u);
    return u;
  }
  /** ��¼ϵͳ: ����email pwd ��¼�ɹ�����һ��ϵͳ�û����� */
  public User login(String email, String pwd){
    User user = users.get(email);
    if(user==null){
      throw new RuntimeException("���޴���!");
    }
    if(user.getPwd().equals(pwd)){
      user.setLastLogin(System.currentTimeMillis());
      return user;//��¼�ɹ�
    }
    throw new RuntimeException("�������");
  }
  /** ��ȡϵͳȫ���ĵ�¼�û��б� */
  public List<User> findAll(){
    return new ArrayList<User>(users.values()); 
  }
  /** ģ����ѯ, ��¼��(email) ����ָ��name�������� */
  public List<User> findByName(String name){
    ArrayList<User> list = new ArrayList<User>();
    for(Iterator<User> i=users.values().iterator();
      i.hasNext();){
      User user = i.next();
      if(user.getEmail().indexOf(name)>=0){
        list.add(user);
      }
    }
    return list;
  }
  /** ɾ���û� */
  public User remove(int id){
    Set<Entry<String, User>> entrySet=users.entrySet();
    User u = null;
    for(Iterator<Entry<String, User>> i = 
      entrySet.iterator();i.hasNext();){
      Entry<String, User> e = i.next();
      if(e.getValue().getId()==id){
        u = e.getValue();
        i.remove();//�Ǵ�entrySetɾ��Entry<email, user>, 
        //���Ǵ�ԭ����usersɾ��Entry,entrySet��users��ͬ����
        break;
      }
    }
    return u;
  }
  public void remove(User user){
    remove(user.getId());
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







