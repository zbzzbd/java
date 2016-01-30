package basic.day02;

import java.util.Random;

public class CharDemo {
  public static void main(String[] args) {
    char c = 0x4e2d;//20013, '中'
    //unicode 
    System.out.println(c);//按照人的习惯输出"字符"
    System.out.println((int)c);//20013
    //'王' 字符字面量
    System.out.println((int)'王');
    System.out.println((int)'0');
    System.out.println((int)'1');
    System.out.println((int)'2');
    System.out.println((int)'3');
    System.out.println((int)'4');
    System.out.println((int)'5');
    System.out.println((int)'6');
    System.out.println((int)'7');
    //...
    System.out.println((int)'A');
    System.out.println((int)'B');
    System.out.println((int)'C');
    
    System.out.println((int)'a');
    System.out.println((int)'b');
    System.out.println((int)'c');

    Random random = new Random();
    int r = random.nextInt(26);//[0,26)
    
    char ch = (char)('A'+r);
    System.out.println(ch); 
    



    
    
  }

}
