package day10;
import java.io.*;
import java.util.*;
/** IO 工具类 */
public class IOUtils {
  /**
   * 获取目录的全部文件
   * @param dir
   * @return
   */
  public static List<File> listFile(File dir){
    File[] files = dir.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isFile();
      }
    });
    return new ArrayList<File>(Arrays.asList(files)); 
  }
  /**
   * 获取目录的全部文件, 指定扩展名的文件
   * @param dir
   * @return
   */
  public static List<File> listFile(
      File dir, final String ext){
    
    File[] files = dir.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isFile() && pathname.getName().endsWith(ext);
      }
    });
    return new ArrayList<File>(Arrays.asList(files)); 
  }
  /**
   * 递归获取目录的全部文件 
   * @param dir
   * @return
   */
  public static List<File> listAll(
      File dir){
    List<File> all = listFile(dir);
    File[] subs = dir.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });
    for (File sub : subs) {
      all.addAll(listAll(sub));
    }
    return all;
  }
  /**
   * 递归获取目录的全部文件, 指定扩展名的文件
   * @param dir
   * @return
   */
  public static List<File> listAll(
      File dir, String ext){
    List<File> all = listFile(dir, ext);
    File[] subs = dir.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });
    for (File sub : subs) {
      all.addAll(listAll(sub, ext));
    }
    return all;
  }
  
  /**
   * 复制文件
   */
  public static void cp(String from, String to)
    throws IOException {
    cp(new File(from), new File(to));
    //Thread.sleep(millis);
    //Thread t = Thread.currentThread();
  }
  /**
   * 复制文件
   */
  public static void cp(File from, File to)
    throws IOException {
    cp(new FileInputStream(from), 
        new FileOutputStream(to));
  }
  /**
   * 复制文件
   */
  public static void cp(InputStream in, 
      OutputStream out)
    throws IOException {
    //1K byte 的缓冲区!
    byte[] buf = new byte[1024];
    int count;
    while((count=in.read(buf))!=-1){
      System.out.println(count); 
      out.write(buf, 0, count);
    }
    in.close();
    out.close();
  }
  /**
   * 从流中读取一行文本, 读取到一行的结束为止
   * @param in
   * @return 一行文本
   */
  public static String readLine(
      InputStream in, String charset)
    throws IOException{
    byte[] buf = {};
    int b;
    while(true){
      b = in.read();
      if(b=='\n' || b=='\r' || b==-1){//编码是否是回车换行
        break;
      }
      buf=Arrays.copyOf(buf, buf.length+1);
      buf[buf.length-1]=(byte)b;
    }
    if(buf.length==0 && b==-1)
      return null;
    return new String(buf,charset);
  }
  
  
  /**
   * 读取文件的全部内容到一个byte数组
   * 可以缓存一个"小"文件到堆内存中
   */
  public static byte[] read(String filename)
    throws IOException{
    return read(new File(filename));
  }
  /**
   * 读取文件的全部内容到一个byte数组
   * 可以缓存一个"小"文件到堆内存中
   */
  public static byte[] read(File file)
    throws IOException{
    //用RAF打开文件
    RandomAccessFile raf = 
      new RandomAccessFile(file, "r");
    //安装文件的长度开辟 缓冲区数组(byte数组)
    byte[] buf = new byte[(int)raf.length()];
    //读取文件的缓冲区
    raf.read(buf);
    //关闭文件(RAF)
    raf.close();
    //返回缓冲区数组引用.
    return buf;
  }
  /**
   * 读取文件的全部内容到一个byte数组
   * 可以缓存一个"小"文件到堆内存中
   * 如: 文件内容: ABC中 读取为: {41, 42, 43, d6, d0}
   */
  public static byte[] read(InputStream in)
    throws IOException{
    byte[] ary = new byte[in.available()];
    in.read(ary);
    in.close();
    return ary;
  }
   /**
   * 连接byte 数组的全部内容为字符串, 
   * 以hex(十六进制)形式连接
   * 如: 数组{0x41, 0x42, 0x43, 0xd6, 0xd0}
   *    结果:  "[41, 42, 43, d6, d0]"
   */
  public static String join(byte[] ary){
    if(ary==null || ary.length==0)
      return "[]";
    StringBuilder buf = 
      new StringBuilder();
    buf.append("[").append(
        leftPad(Integer.toHexString(ary[0]&0xff),'0',2));
    for(int i=1; i<ary.length; i++){
      String hex=Integer.toHexString(ary[i]&0xff);
      buf.append(",").append(leftPad(hex,'0',2));
    }
    buf.append("]");
    return buf.toString();
  }
  
  public static String toBinString(byte[] ary){
    if(ary==null || ary.length==0)
      return "[]";
    StringBuilder buf = 
      new StringBuilder();
    buf.append("[").append(
        leftPad(Integer.toBinaryString(ary[0]&0xff),'0',8));
    for(int i=1; i<ary.length; i++){
      String hex=Integer.toBinaryString(ary[i]&0xff);
      buf.append(",").append(leftPad(hex,'0',8));
    }
    buf.append("]");
    return buf.toString();
  }
  /**
   * 实现leftPad功能, 对字符串实现左填充
   * @param str 被填充字符串: 5
   * @param ch 填充字符: #
   * @param length 填充以后的长度: 8
   * @return "#######5"
   */
  public static String leftPad(
      String str, char ch, int length){
    if(str.length() == length){
      return str;
    }
    char[] chs = new char[length];
    Arrays.fill(chs, ch);
    System.arraycopy(str.toCharArray(), 0, chs, 
        length - str.length(), str.length());
    return new String(chs);
  }
  /**
   * 将text追加到文件 filename的尾部 
   * 使用系统默认文本编码
   */
  public static void println (
      String filename, String text) 
    throws IOException{
    println(new File(filename),text);
  }
  public static void println(
      File file, String text)throws IOException{
    OutputStream out = new FileOutputStream(file,true);
    println(out, text);
    out.close();
  }
  /**
   * 向流中输出一行字符串, 使用默认编码
   * 不关闭流
   * @param out 目标流
   * @param text 文本
   * @throws IOException
   */
  public static void println(
      OutputStream out, String text)throws IOException{
    out.write(text.getBytes());
    out.write('\n');
  }
  /**
   * 向流中输出一行字符串, 使用指定的编码
   * 不关闭流
   * @param out 目标流
   * @param text 文本
   * @param charset 指定的编码
   * @throws IOException
   */
  public static void println(
      OutputStream out, String text, String charset)throws IOException{
    out.write(text.getBytes(charset));
    out.write('\n');
  }
}





