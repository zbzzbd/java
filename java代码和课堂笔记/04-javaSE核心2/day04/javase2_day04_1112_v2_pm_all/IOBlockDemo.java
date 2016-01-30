package javase2.day04;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
/** IO 阻塞(IO 等待挂起) 现象, 
 * read(),readInt(),readLine()... 都是IO Block方法 */
public class IOBlockDemo {
  public static void main(String[] args)
    throws IOException {
    Scanner console = new Scanner(System.in);
    System.out.print("输入信息:");
    //nextLine() 引起当前线程(main),发生IO Block
    //当前线程状态Block, 离开Running(离开处理器) 
    //直到IO完成为止, main线程返回到Runnable
    //.nextLine()IO完成: 一行(回车)输入结束时候
    String str = console.nextLine();
    System.out.println(str);
    System.out.print("in.read():");
    InputStream in = System.in;
    int b = in.read();//IO Block 方法
    System.out.println(b); 
  }
}
