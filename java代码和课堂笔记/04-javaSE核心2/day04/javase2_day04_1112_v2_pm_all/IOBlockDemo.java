package javase2.day04;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
/** IO ����(IO �ȴ�����) ����, 
 * read(),readInt(),readLine()... ����IO Block���� */
public class IOBlockDemo {
  public static void main(String[] args)
    throws IOException {
    Scanner console = new Scanner(System.in);
    System.out.print("������Ϣ:");
    //nextLine() ����ǰ�߳�(main),����IO Block
    //��ǰ�߳�״̬Block, �뿪Running(�뿪������) 
    //ֱ��IO���Ϊֹ, main�̷߳��ص�Runnable
    //.nextLine()IO���: һ��(�س�)�������ʱ��
    String str = console.nextLine();
    System.out.println(str);
    System.out.print("in.read():");
    InputStream in = System.in;
    int b = in.read();//IO Block ����
    System.out.println(b); 
  }
}
