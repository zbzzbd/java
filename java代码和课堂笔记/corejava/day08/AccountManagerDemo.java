package day08;

import java.util.Arrays;
import java.util.Scanner;

public class AccountManagerDemo {
 
  public static void main(String[] args){
    AccountManager manager = 
      new AccountManagerImpl();
    System.out.println("��ӭʹ���ʺŹ���ϵͳ!");
    Scanner sc  = new Scanner(System.in);
    while(true){
      System.out.print("1 ע��, 2 ��¼, 3 ��ʾȫ��, 4 email��ѯ, 0 �뿪:");
      String cmd = sc.nextLine();
      if("1".equals(cmd)){
        System.out.print("�û���:");
        String name = sc.nextLine();
        System.out.print("����:");
        String pwd = sc.nextLine();
        System.out.print("email:");
        String email = sc.nextLine();
        manager.reg(name, pwd, email);
      }else if("2".equals(cmd)){
        System.out.print("�û���:");
        String name = sc.nextLine();
        System.out.print("����:");
        String pwd = sc.nextLine();
        User u = manager.login(name, pwd);
        System.out.println("��ӭ��:" + u.getName());
      }else if("3".equals(cmd)){
        User[] all = manager.findAll();
        System.out.println(Arrays.toString(all));
      }else if("4".equals(cmd)){
        System.out.print("email:");
        String email = sc.nextLine();
        User[] all = manager.findByEmail(email);
        System.out.println(Arrays.toString(all));
      }else if("0".equals(cmd)){
        System.out.println("Bye!");
        break;
      }
    }
  }

}
