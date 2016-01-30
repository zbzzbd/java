package javase2.day05.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** �ļ��Ĺ����� */
public class IOUtils {
  /** һ���Խ��ļ���ȡ�������� */
  public static byte[] read(String file)
      throws IOException {
    return read(new File(file));
  }

  public static byte[] read(File file)
      throws IOException {
    // �����ļ���С ��������byte[]����
    byte[] buf = new byte[(int) file.length()];
    // ��RAFֻ�����ļ�
    RandomAccessFile raf = new RandomAccessFile(
        file, "r");
    // ʹ�� raf.read(byte[]) ��ȡȫ������
    raf.read(buf);
    // �ر��ļ�
    raf.close();
    return buf;
  }

  /** �����ļ�, ����in��out */
  public static void cp(String in, String out)
      throws IOException {
    cp(new File(in), new File(out));
  }

  public static void cp(File in, File out)
      throws IOException {
    InputStream fin = new FileInputStream(in);// ����ʹ��File����
    OutputStream fout = new FileOutputStream(
        out);
    cp(fin, fout);
    fin.close();
    fout.close();// �ر�
  }

  /** �����ļ�, ����in��out, ���ر��� */
  public static void cp(InputStream in,
      OutputStream out) throws IOException {
    byte[] buf = new byte[1024 * 512];// 512K����
    int count;
    while ((count = in.read(buf)) != -1) {// ��ȡ��buf
      // System.out.println(count);//
      out.write(buf, 0, count); // д�뵽�����
    }
    out.flush(); // ˢ�����嵽Ŀ����
  }

  /** �������� */
  public static void cp2(InputStream in,
      OutputStream out) throws IOException {
    int b;
    while ((b = in.read()) != -1) { // ��ȡһ��byte
      out.write(b); // д�뵽�����
    }
    out.flush(); // ˢ�����嵽Ŀ����
  }

  public static byte[] read(InputStream in)
      throws IOException {
    byte[] buf = new byte[in.available()];
    in.read(buf);
    in.close();
    return buf;
  }

  public static String toHexString(byte[] ary) {
    if (ary == null || ary.length == 0)
      return "";
    StringBuilder buf = new StringBuilder();
    if ((ary[0] & 0xff) <= 0xf) {
      buf.append("0");
    }
    buf.append(Integer
        .toHexString(ary[0] & 0xff));
    for (int i = 1; i < ary.length; i++) {
      buf.append(",");
      if ((ary[i] & 0xff) <= 0xf) {
        buf.append("0");
      }
      buf.append(Integer
          .toHexString(ary[i] & 0xff));
    }
    return buf.toString();
  }

  public static String readHexString(
      String filename) throws IOException {
    return toHexString(read(filename));
  }

  /**
   * ���ļ��з�Ϊ ָ����С��ϵ���ļ� ��: IOUtiles.split("test.zip", 1024) ���ļ� test.zip �з�Ϊ
   * 1024K(1M) ��С�� ϵ���ļ� : test.zip.0, test.zip.1,...
   * 
   * @param filename
   *          Դ�ļ���
   * @param size
   *          �ļ���С, ��kΪ��λ
   */
  public static void split(String file,
      int size) throws IOException {
    if (size <= 0) {
      throw new IllegalArgumentException(
          "��ɶѽ!");
    }
    int idx = 0;// �ļ������
    InputStream in = new BufferedInputStream(
        new FileInputStream(file));
    OutputStream out = new BufferedOutputStream(
        new FileOutputStream(file + "."
            + idx++));
    int b;
    int count = 0;
    while ((b = in.read()) != -1) {
      out.write(b);
      count++;
      if (count % (size * 1024) == 0) {
        out.close();
        out = new BufferedOutputStream(
            new FileOutputStream(file + "."
                + idx++));
      }
    }
    in.close();
    out.close();
  }

  /**
   * �������淽����ϵ���ļ�Ϊһ���ļ� ��: IOUtiles.join("test.zip.0"); ��Ӳ��������һ��û����ŵ��ļ�: test.zip
   * 
   * @param basename
   *          ��һ���ļ�, ��test.zip.0
   */
  public static void join(String file)
      throws IOException {
    String filename = file.substring(0, file
        .lastIndexOf("."));
    String num = file.substring(file
        .lastIndexOf(".") + 1);
    int idx = Integer.parseInt(num);
    OutputStream out = new FileOutputStream(
        filename);
    File f = new File(filename + "." + idx++);
    while (f.exists()) {
      InputStream in = new FileInputStream(f);
      cp(in, out);
      in.close();
      f = new File(filename + "." + idx++);
    }
    out.close();
  }

  /**
   * ���������л��������� ����ʹ�ñ䳤����ʵ��, ����ByteArrayOutputStreamʵ��
   * 
   * @param obj
   *          һ��ʵ�����л��ӿڵĶ���
   * @return �������
   * @throws IOException
   */
  public static byte[] serialize(
      Serializable obj) throws IOException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(
        os);

    out.writeObject(obj);// �������л�, foo
    out.close();
    byte[] ary = os.toByteArray();
    return ary;
  }

  /**
   * �����л�byte���� ������
   * 
   * @param ary
   * @return
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public static Object unserialize(byte[] data)
      throws IOException,
      ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(
        new ByteArrayInputStream(data));
    Object o = in.readObject();// �����л�
    in.close();
    return o;
  }

  /**
   * ��ȡĿ¼��ȫ���ļ�
   * 
   * @param dir
   * @return
   */
  public static List<File> listFile(File dir) {
    File[] files = dir
        .listFiles(new FileFilter() {
          public boolean accept(File pathname) {
            return pathname.isFile();
          }
        });
    return new ArrayList<File>(Arrays
        .asList(files));
  }

  /**
   * ��ȡĿ¼��ȫ���ļ�, ָ����չ�����ļ�
   * 
   * @param dir
   * @return
   */
  public static List<File> listFile(File dir,
      final String ext) {

    File[] files = dir
        .listFiles(new FileFilter() {
          public boolean accept(File pathname) {
            return pathname.isFile()
                && pathname.getName()
                    .endsWith(ext);
          }
        });
    return new ArrayList<File>(Arrays
        .asList(files));
  }

  /**
   * �ݹ��ȡĿ¼��ȫ���ļ�
   * 
   * @param dir
   * @return
   */
  public static List<File> listAll(File dir) {
    List<File> all = listFile(dir);
    File[] subs = dir
        .listFiles(new FileFilter() {
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
   * 
   * @param dir
   * @return
   */
  public static List<File> listAll(File dir,
      String ext) {
    List<File> all = listFile(dir, ext);
    File[] subs = dir
        .listFiles(new FileFilter() {
          public boolean accept(File pathname) {
            return pathname.isDirectory();
          }
        });
    for (File sub : subs) {
      all.addAll(listAll(sub, ext));
    }
    return all;
  }

  public static String readLine(InputStream in)
      throws IOException {
    ByteArrayOutputStream out = 
      new ByteArrayOutputStream();
    int b;
    while (true) {
      b = in.read();
      if (b == '\n' || b == '\r' || b == -1) {// �����Ƿ��ǻس�����
        break;
      }
      out.write(b);
    }
    return new String(out.toByteArray());
  }

  /**
   * �����ж�ȡһ���ı�, ��ȡ��һ�еĽ���Ϊֹ
   * 
   * @param in
   * @return һ���ı�
   */
  public static String readLine(
      InputStream in, String charset)
      throws IOException {
    byte[] buf = {};
    int b;
    while (true) {
      b = in.read();
      if (b == '\n' || b == '\r' || b == -1) {// �����Ƿ��ǻس�����
        break;
      }
      buf = Arrays.copyOf(buf, buf.length + 1);
      buf[buf.length - 1] = (byte) b;
    }
    if (buf.length == 0 && b == -1)
      return null;
    return new String(buf, charset);
  }

  /**
   * ��text׷�ӵ��ļ� filename��β�� ʹ��ϵͳĬ���ı�����
   */
  public static void println(String filename,
      String text) throws IOException {
    println(new File(filename), text);
  }

  public static void println(File file,
      String text) throws IOException {
    OutputStream out = new FileOutputStream(
        file, true);
    println(out, text);
    out.close();
  }

  /**
   * ���������һ���ַ���, ʹ��Ĭ�ϱ��� ���ر���
   * 
   * @param out
   *          Ŀ����
   * @param text
   *          �ı�
   * @throws IOException
   */
  public static void println(OutputStream out,
      String text) throws IOException {
    out.write(text.getBytes());
    out.write('\n');
    out.flush();
  }

  /**
   * ���������һ���ַ���, ʹ��ָ���ı��� ���ر���
   * 
   * @param out
   *          Ŀ����
   * @param text
   *          �ı�
   * @param charset
   *          ָ���ı���
   * @throws IOException
   */
  public static void println(OutputStream out,
      String text, String charset)
      throws IOException {
    out.write(text.getBytes(charset));
    out.write('\n');
  }

}
