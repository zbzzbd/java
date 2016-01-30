package javase2.day01;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/** ��������ʾ */
public class InputStreamDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "raf.txt";
    //InputStream: ������ⲿ��Ӧ�ó����ڴ������(in)
    //InputStream �ж�����Ҫ�������ȡ���� in.read()
    // in.read() ��in(��:�����ļ�) ��ȡһ��byte���ڴ����
    //FileInputStream: �̳���InputStream�ڴ����ļ���
    //ʵ���˶�ȡ����(����, in)�ĵ�Ӧ�ó����ڴ��������
    InputStream in = new FileInputStream(file);
    //in.read() �Ķ�����raf.read() ������ȫ��ͬ
    //in.read() �ڶ�ȡ�ļ�ʱ��, �ļ�ָ��ֻ�ܵ����ƶ�
    //�������seek!, ����Ľ���: ������:InputStream
    //int b = in.read();//��ȡһ��byte���ڴ����
    //System.out.println(Integer.toHexString(b));//41
    int b;
    while((b=in.read())!=-1){
      System.out.print(Integer.toHexString(b)+" "); 
    }
    in.close();//�ļ�ʹ�����, ��عر�!
  }
}
