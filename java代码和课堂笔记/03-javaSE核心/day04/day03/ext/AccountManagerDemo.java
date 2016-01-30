package javase1.day03.ext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/** 
 * 帐号登录管理的原型 
 */
public class AccountManagerDemo {
  public static void main(String[] args) {
    AccountManager mgr = new AccountManager();
    Scanner console = new Scanner(System.in);
    while(true){
      System.out.print("1 注册, 2 登录, " +
          "3 全部, 4 查询, 5 删除, 0 离开:");
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
        System.out.println("亲, 88!");
        break;
      }
    }
  }
  public static void login(AccountManager mgr,Scanner s){
    String str;
    while(true){
      System.out.print("输入email和密码(email pwd):");
      str = s.nextLine();
      if(str.matches("^.+\\s+\\w+$")){
        break; 
      }
      System.out.println("格式错误");
    }
    String[] data = str.split("\\s+");
    String email = data[0]; String pwd = data[1];
    User newone = mgr.login(email, pwd);
    System.out.println("欢迎"+newone+"回来!"); 
  }
  public static void listAll(AccountManager mgr,Scanner s){
    List<User> all = mgr.findAll();
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+u);  
    }
  }
  public static void find(AccountManager mgr,Scanner s){
    System.out.print("输入用户名:");
    String name = s.nextLine();
    List<User> all = mgr.findByName(name);
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+u); 
    }
  }
  public static void delete(AccountManager mgr,Scanner s){
    System.out.println("选择哪个要删除:");
    int index = 0;
    List<User> all = mgr.findAll();
    for(Iterator<User> i=all.iterator(); i.hasNext();){
      User u = i.next();
      System.out.println("\t"+(index++)+":"+u);  
    }
    System.out.print("序号:");
    index = s.nextInt();
    User u = all.get(index);
    mgr.remove(u);
    System.out.println("成功删除:"+u); 
  }
  public static void reg(AccountManager mgr,Scanner s){
    String str;
    while(true){
      System.out.print("输入email和密码(email pwd):");
      str = s.nextLine();
      if(str.matches("^.+\\s+\\w+$")){
        break; 
      }
      System.out.println("格式错误");
    }
    String[] data = str.split("\\s+");
    String email = data[0]; String pwd = data[1];
    User newone = mgr.reg(email, pwd);
    System.out.println("恭喜"+newone+"成功注册!"); 
  }
}
/** 账户的管理(增删改查)功能 */
class AccountManager{
  /** users是map集合存储登录用户,key是email, 不重复,
   * value是User对象 */
  private HashMap<String, User> users = 
    new HashMap<String, User>();
  /** id 代表用户序号 */
  private int id = 1;
  /** 注册用户: 前提参数是email和pwd,结果是注册成功的用户对象 */
  public User reg(String email, String pwd){
    //User u = users.get(email);//先查询已有用户
    //if(u!=null){//如果有用户就抛异常, 提前结束当前方法
    //  throw new RuntimeException("用户已经注册!");
    //}
    if(users.containsKey(email)){
      throw new RuntimeException("用户已经注册!");
    }
    User u = new User(id++, email, pwd);
    users.put(email, u);
    return u;
  }
  /** 登录系统: 参数email pwd 登录成功返回一个系统用户对象 */
  public User login(String email, String pwd){
    User user = users.get(email);
    if(user==null){
      throw new RuntimeException("查无此人!");
    }
    if(user.getPwd().equals(pwd)){
      user.setLastLogin(System.currentTimeMillis());
      return user;//登录成功
    }
    throw new RuntimeException("密码错误");
  }
  /** 获取系统全部的登录用户列表 */
  public List<User> findAll(){
    return new ArrayList<User>(users.values()); 
  }
  /** 模糊查询, 登录名(email) 包含指定name的所有人 */
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
  /** 删除用户 */
  public User remove(int id){
    Set<Entry<String, User>> entrySet=users.entrySet();
    User u = null;
    for(Iterator<Entry<String, User>> i = 
      entrySet.iterator();i.hasNext();){
      Entry<String, User> e = i.next();
      if(e.getValue().getId()==id){
        u = e.getValue();
        i.remove();//是从entrySet删除Entry<email, user>, 
        //就是从原集合users删除Entry,entrySet和users是同集合
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







