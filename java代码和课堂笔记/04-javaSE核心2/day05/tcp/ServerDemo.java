package javase2.day05.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** TCP ������ԭ����ʾ */
public class ServerDemo {
  public static void main(String[] args) 
    throws IOException {
    ServerDemo server = new ServerDemo();
    server.start();
  }
  public void start() throws IOException{
    //����ServerSocket�󶨵�ǰ����(Host)�ķ���˿�
    //��ռ��8888�˿��ṩ����, �˿ڲ����ظ�ռ��(��) 
    //�˿ں�: 0~65535, 1K ��������ϵͳʹ��.
    //�����ʧ�ܻ��׳��쳣, �󶨳ɹ��ʹ����˶���ss
    ServerSocket ss = new ServerSocket(8888);
    while(true){
      //ss.accept()�ǿ�ʼ�ȴ���8888�˿ڵļ���
      //ss.accept()��IO Block����, �ȴ��ͻ��˵�����
      //����пͻ������ӽ���, IO�����, ����Block
      //����һ��Socketʵ��s,����Կͻ��˵�����s�а���(in,out)
      //in ����ͻ��˵�����������, out������������ͻ��˵���
      Socket s = ss.accept();
      //�����ͻ��˷����߳�, ��������ͻ����������Ӧ
      new Service(s).start();
    }
    
  }  
  class Service extends Thread{
    Socket s;
    public Service(Socket s) {
      this.s = s;
    }
    public void run(){
      try{//telnet ip port  /sbin/ifconfig
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        Scanner s = new Scanner(in);
        out.write("��Ҫ��ɶ?\n".getBytes());
        out.flush();
        while(true){
          String str = s.nextLine();
          if(str.equals("����")){
            out.write("ľ�а�?\n".getBytes());
            out.flush();
          }else if(str.startsWith("bye")){
            out.write("��,�ټ�ѽ?\n".getBytes());
            out.flush();  this.s.close();  break;
          }
        }
      }catch(IOException e){
        e.printStackTrace();
        throw new RuntimeException(e); 
      }
    }
  }
  
}






