package javase2.day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/** RamdomAccessFile 使用演示 */
//data:   41 42 ff ff ff fe ff ff ff fe
//index:   0  1  2  3  4  5  6  7  8  9 10
//pointer: ^ 
public class RAFDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "raf.txt"; 
    RandomAccessFile raf = 
      new RandomAccessFile(file, "rw");
    //获取当前文件指针位置
    System.out.println(raf.getFilePointer());//0
    //write(int) 方法将int数据的低8位写入到文件当前指针位置,
    //高24位被忽略掉,自动移动文件指针到下一个位置,方便下次写入
    raf.write(0x41+2048); 
    System.out.println(raf.getFilePointer());//1
    raf.write(0xff42); 
    System.out.println(raf.getFilePointer());//2
    int i = 0xfffffffe;// -2
    //i = 11111111 11111111 11111111 11111110
    raf.write(i>>>24);//00000000 00000000 00000000 11111111
    raf.write(i>>>16);//00000000 00000000 11111111 11111111
    raf.write(i>>>8);//00000000 11111111 11111111 11111111 
    raf.write(i);//11111111 11111111 11111111 11111110
    raf.writeInt(i);// 还有 writeLong(l) 
    System.out.println(raf.length());
    System.out.println(raf.getFilePointer()); 
    String str = "中国北京";//中: d6 d0 
    byte[] buf = str.getBytes("GBK");//获得字符串的GBK编码
    raf.write(buf);//将byte数组的全部写入到文件中
    System.out.println(raf.length());//18
    
    raf.seek(0);//移动文件指针, 到0, 就是返回头部
    //raf.read() 从文件当前指针位置读取一个byte(8位), 
    //填充的int数据的低8位, 高24位保持0, 返回这个int.
    //会自动移动文件指针到下一个位置, 准备下次读取.
    //当到文件末尾(EOF = End Of File) read() 方法返回
    // ffffffff(-1) , 可以利用-1判断是否到文件尾部
    int b = raf.read();
    System.out.println(b);//65 
    b = raf.read();
    System.out.println(b);//66
    int b1 = raf.read();//ff
    int b2 = raf.read();//ff
    int b3 = raf.read();//ff
    int b4 = raf.read();//fe
    int x = (b1<<24)+(b2<<16)+(b3<<8)+b4;
    System.out.println(x);//-2
    x = raf.readInt();//readLong()
    System.out.println(x);//-2
    final int EOF = -1;
    raf.seek(0);
    while((b = raf.read())!=EOF){
      System.out.print(Integer.toHexString(b)+" "); 
    }
    raf.seek(10);
    byte[] gbk = new byte[12]; 
    //raf.read(byte[]) 方法从文件中读取尽可能多byte数据
    //填充到数组(缓冲区), 返回读取的个数, 返回-1表示EOF
    int n = raf.read(gbk);
    String s = new String(gbk, 0, 8, "GBK"); 
    System.out.println("\n"+s);//中国北京
    raf.close();//务必关闭文件
  }
}








