package day11;
import java.io.*;
import java.util.*;
/** IO ������ */
public class IOUtils {
  /**
   * ��ȡĿ¼�µ�ȫ���ļ�
   * @param dir
   * @return �ļ�����
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
   * ��ȡĿ¼��ȫ���ļ�, ָ����չ�����ļ�
   * @param dir
   * @return
   */
  public static List<File> listFile(
      File dir, final String ext){
    File[] files = dir.listFiles(new FileFilter() {
      public boolean accept(File pathname) {
        return pathname.isFile() 
        	&& pathname.getName().endsWith(ext);
      }
    });
    return new ArrayList<File>(Arrays.asList(files)); 
  }
  /**
   * �ݹ��ȡĿ¼��ȫ���ļ���������Ŀ¼�µ��ļ� 
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
   * �ݹ��ȡĿ¼��ȫ���ļ�, ָ����չ�����ļ�
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
   * �����ļ�
   * ��fromָ�����ļ����Ƶ�toָ����λ��
   */
  public static void cp(String from, String to)
    throws IOException {
    cp(new File(from), new File(to));//���ñ������صķ���cp
    //Thread.sleep(millis);
    //Thread t = Thread.currentThread();
  }
  /**
   * �����ļ�
   */
  public static void cp(File from, File to)
    throws IOException {
    cp(new FileInputStream(from), 
        new FileOutputStream(to));//���ñ������صķ���cp
  }
  /**
   * �����ļ�
   * ����ʵ�ָ��Ƶķ���
   * in = new FileInputStream(new File(from));
   * out = new FileOutputStream(new File(to));
   */
  public static void cp(InputStream in, 
      OutputStream out)
    throws IOException {
    //1K byte �Ļ�����!
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
   * �����ж�ȡһ���ı�, ��ȡ��һ�еĽ���Ϊֹ
   * @param in
   * @return һ���ı�
   */
  public static String readLine(
      InputStream in, String charset)
    throws IOException{
    byte[] buf = {};//buf.length = 0;
    int b;
    while(true){
      b = in.read();
      if(b=='\n' || b=='\r' || b==-1){//�����Ƿ��ǻس�����
        break;
      }
      buf=Arrays.copyOf(buf, buf.length+1);//jdk1.6
      buf[buf.length-1]=(byte)b;
    }
    if(buf.length==0 && b==-1)
      return null;
    return new String(buf,charset);
  }
  
  
  /**
   * ��ȡ�ļ���ȫ�����ݵ�һ��byte����
   * ���Ի���һ��"С"�ļ������ڴ���
   */
  public static byte[] read(String filename)
    throws IOException{
    return read(new File(filename));
  }
  /**
   * ��ȡ�ļ���ȫ�����ݵ�һ��byte����
   * ���Ի���һ��"С"�ļ������ڴ���
   */
  public static byte[] read(File file)
    throws IOException{
    //��RAF���ļ�
    RandomAccessFile raf = 
      new RandomAccessFile(file, "r");
    //��װ�ļ��ĳ��ȿ��� ����������(byte����)
    byte[] buf = new byte[(int)raf.length()];
    //��ȡ�ļ��Ļ�����
    raf.read(buf);
    //�ر��ļ�(RAF)
    raf.close();
    //���ػ�������������.
    return buf;
  }
  /**
   * ��ȡ�ļ���ȫ�����ݵ�һ��byte����
   * ���Ի���һ��"С"�ļ������ڴ���
   * ��: �ļ�����: ABC�� ��ȡΪ: {41, 42, 43, d6, d0}
   */
  public static byte[] read(InputStream in)
    throws IOException{
    byte[] ary = new byte[in.available()];
    in.read(ary);
    in.close();
    return ary;
  }
   /**
   * ����byte �����ȫ������Ϊ�ַ���, 
   * ��hex(ʮ������)��ʽ����
   * ��: ����{0x41, 0x42, 0x43, 0xd6, 0xd0} ABC��
   *    ���:  "[41, 42, 43, d6, d0]"
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
   * ʵ��leftPad����, ���ַ���ʵ�������
   * @param str ������ַ���: 5
   * @param ch ����ַ�: #
   * @param length ����Ժ�ĳ���: 8
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
   * ��text׷�ӵ��ļ� filename��β�� 
   * ʹ��ϵͳĬ���ı�����
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
   * ���������һ���ַ���, ʹ��Ĭ�ϱ���
   * ���ر���
   * @param out Ŀ����
   * @param text �ı�
   * @throws IOException
   */
  public static void println(
      OutputStream out, String text)throws IOException{
    out.write(text.getBytes());
    out.write('\n');
  }
  /**
   * ���������һ���ַ���, ʹ��ָ���ı���
   * ���ر���
   * @param out Ŀ����
   * @param text �ı�
   * @param charset ָ���ı���
   * @throws IOException
   */
  public static void println(
      OutputStream out, String text, String charset)throws IOException{
    out.write(text.getBytes(charset));
    out.write('\n');
  }
  /**
   * ���л�
   * @param obj �����л��Ķ���
   * @return obj���л����byte����
   */
  public static byte[] serializing(Serializable obj)
  	throws IOException{
	  ByteArrayOutputStream bos 
	  	= new ByteArrayOutputStream();
	  ObjectOutputStream oos 
	  	= new ObjectOutputStream(bos);
	  oos.writeObject(obj);
	  oos.close();
	  return bos.toByteArray();
  }
  /**�����л�
   * @param array �ֽ�����
   * @return Object ��ڲ������鷴���л���Ķ���
   * @throws ClassNotFoundException 
   */
  public static Object unSerializing(byte[] array)
  	throws IOException, ClassNotFoundException
  {
	  ByteArrayInputStream bis 
	  	= new ByteArrayInputStream(array);
	  ObjectInputStream ois 
	  	= new ObjectInputStream(bis);
	  Object obj = ois.readObject();
	  ois.close();
	  return obj;
  }
  /**
   * ���¡(��㸴��)
   * @param obj �����ƵĶ���
   * @return Object obj����ĸ���
   * @throws ClassNotFoundException 
   * @throws IOException 
   */
  public static Object clone(Serializable obj) throws IOException, ClassNotFoundException{
	  return unSerializing(serializing(obj));
  }
  
  /**
   * �з��ļ�, ��: file.dat 
   * �з�Ϊ file.dat.0, file.dat.1 ...
   * @param file
   * @param size ��С, ��KByteΪ��λ
   */
  public static void split(String file, int size)
    throws IOException{
    if(size<=0){
      throw new IllegalArgumentException("��ɶѽ!");
    }
    int idx = 0;//�ļ������
    InputStream in = 
      new BufferedInputStream(
          new FileInputStream(file));
    OutputStream out = 
      new BufferedOutputStream( 
        new FileOutputStream(file+"."+idx++));
    int b; int count = 0;
    while(( b = in.read())!=-1){
      out.write(b);
      count++;
      if(count % (size*1024) ==0){
        out.close();
        out = new BufferedOutputStream(
            new FileOutputStream(file+"."+idx++));
      }
    }
    in.close();
    out.close();
  }
  /**
   * ���ļ���������
   * @param filename �ǵ�һ���ļ���,��:file.dat.0
   */
  public static void join(String file)
    throws IOException{
    String filename = 
      file.substring(0, file.lastIndexOf("."));
    String num = 
      file.substring(file.lastIndexOf(".")+1);
    int idx = Integer.parseInt(num);
    OutputStream out =
          new FileOutputStream(filename);
    File f = new File(filename+"."+idx++);
    while(f.exists()){
      InputStream in =
            new FileInputStream(f);
      cp(in, out);
      in.close();
      f = new File(filename+"."+idx++);
    }
    out.close();
  }
}





