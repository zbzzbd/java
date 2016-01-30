package javase2.day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/** RamdomAccessFile ʹ����ʾ */
//data:   41 42 ff ff ff fe ff ff ff fe
//index:   0  1  2  3  4  5  6  7  8  9 10
//pointer: ^ 
public class RAFDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "raf.txt"; 
    RandomAccessFile raf = 
      new RandomAccessFile(file, "rw");
    //��ȡ��ǰ�ļ�ָ��λ��
    System.out.println(raf.getFilePointer());//0
    //write(int) ������int���ݵĵ�8λд�뵽�ļ���ǰָ��λ��,
    //��24λ�����Ե�,�Զ��ƶ��ļ�ָ�뵽��һ��λ��,�����´�д��
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
    raf.writeInt(i);// ���� writeLong(l) 
    System.out.println(raf.length());
    System.out.println(raf.getFilePointer()); 
    String str = "�й�����";//��: d6 d0 
    byte[] buf = str.getBytes("GBK");//����ַ�����GBK����
    raf.write(buf);//��byte�����ȫ��д�뵽�ļ���
    System.out.println(raf.length());//18
    
    raf.seek(0);//�ƶ��ļ�ָ��, ��0, ���Ƿ���ͷ��
    //raf.read() ���ļ���ǰָ��λ�ö�ȡһ��byte(8λ), 
    //����int���ݵĵ�8λ, ��24λ����0, �������int.
    //���Զ��ƶ��ļ�ָ�뵽��һ��λ��, ׼���´ζ�ȡ.
    //�����ļ�ĩβ(EOF = End Of File) read() ��������
    // ffffffff(-1) , ��������-1�ж��Ƿ��ļ�β��
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
    //raf.read(byte[]) �������ļ��ж�ȡ�����ܶ�byte����
    //��䵽����(������), ���ض�ȡ�ĸ���, ����-1��ʾEOF
    int n = raf.read(gbk);
    String s = new String(gbk, 0, 8, "GBK"); 
    System.out.println("\n"+s);//�й�����
    raf.close();//��عر��ļ�
  }
}








