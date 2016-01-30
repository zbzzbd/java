package javase1.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** ����HashMapʵ���û�ע���¼���� */
public class HashMapDemo2 {
  public static void main(String[] args) {
    //ɢ�б�洢�û���Ϣ, key���û���, Value���û�����
    Map<String, User> users = 
      new HashMap<String, User>();
    users.put("Tom", new User(1, "Tom", "123"));
    users.put("Andy", new User(2, "Andy", "123"));
    users.put("John", new User(3, "John", "123"));
    
    Scanner in = new Scanner(System.in);
    while(true){
      System.out.print("�����û���������(name pwd):");
      String str = in.nextLine();
      if(! str.matches("\\s*\\w{3,10}\\s+\\w{3,10}\\s*")){
        System.out.println("����!");
        continue;
      }
      String[] data = str.trim().split("\\s+");
      String name = data[0];
      String pwd = data[1];
      User user = users.get(name);
      if(user==null){
        System.out.println("���޴���!"); 
        continue;
      }
      if(user.pwd.equals(pwd)){
        System.out.println("��ӭ"+user+"����!");
        break;
      }
      System.out.println("�������!");
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
  @Override//ע��Java 5 �Ժ��ṩ���﷨����, ��鷽������
  public String toString() {
    return name;
  }
  
}



