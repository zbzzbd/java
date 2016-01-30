package javase2.day01;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/** 输入流演示 */
public class InputStreamDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "raf.txt";
    //InputStream: 代表从外部到应用程序内存的输入(in)
    //InputStream 中定义重要的输入读取方法 in.read()
    // in.read() 从in(如:磁盘文件) 读取一个byte到内存变量
    //FileInputStream: 继承了InputStream在磁盘文件上
    //实现了读取数据(输入, in)的到应用程序内存变量方法
    InputStream in = new FileInputStream(file);
    //in.read() 的定义与raf.read() 定义完全相同
    //in.read() 在读取文件时候, 文件指针只能单向移动
    //不能向回seek!, 形象的解释: 输入流:InputStream
    //int b = in.read();//读取一个byte到内存变量
    //System.out.println(Integer.toHexString(b));//41
    int b;
    while((b=in.read())!=-1){
      System.out.print(Integer.toHexString(b)+" "); 
    }
    in.close();//文件使用完毕, 务必关闭!
  }
}
