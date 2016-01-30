package javase1.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 利用HashMap实现用户注册登录过程 */
public class HashMapDemo2 {
  public static void main(String[] args) {
    //散列表存储用户信息, key是用户名, Value是用户对象
    Map<String, User> users = 
      new HashMap<String, User>();
    users.put("Tom", new User(1, "Tom", "123"));
    users.put("Andy", new User(2, "Andy", "123"));
    users.put("John", new User(3, "John", "123"));
    
    Scanner in = new Scanner(System.in);
    while(true){
      System.out.print("输入用户名和密码(name pwd):");
      String str = in.nextLine();
      if(! str.matches("\\s*\\w{3,10}\\s+\\w{3,10}\\s*")){
        System.out.println("错了!");
        continue;
      }
      String[] data = str.trim().split("\\s+");
      String name = data[0];
      String pwd = data[1];
      User user = users.get(name);
      if(user==null){
        System.out.println("查无此人!"); 
        continue;
      }
      if(user.pwd.equals(pwd)){
        System.out.println("欢迎"+user+"光临!");
        break;
      }
      System.out.println("密码错误!");
    }
  }
}
class User{
  int id;
  String name;
  String pwd;
  public User(int id, String name, String pwd) {
    this.id = id;
    this.name = name;
    this.pwd = pwd;
  }
  @Override//注释Java 5 以后提供的语法现象, 检查方法覆盖
  public String toString() {
    return name;
  }
  
}



