package javase2.day05.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
  public static void main(String[] args) 
    throws IOException {
    ClientDemo client = new ClientDemo();
    client.open();
  }
  public void open() throws IOException{
    //new Socket(host, port)�ᷢ��tcp����,���ӵ�host:port
    //������ӳɹ�, �ᴴ��ʵ��s, �������ʧ�ܻ��׳�IO�쳣. 
    //new Socket(host, port)�ɹ�, ������accept() Ҳͬʱ
    //ִ�гɹ�,����IO Block, ���ҷ��ط�������Socketʵ��s 
    Socket s = new Socket("localhost", 8888);
    //�ͻ��˵�in ���ӵ������out
    InputStream in = s.getInputStream();
    //�ͻ��˵�out���ӵ���������in
    OutputStream out = s.getOutputStream();
    //Reader�̸߳���: �ӿ���̨��ȡ��Ϣд�뵽��������out.
    new Reader(out).start();
    //Writer�̸߳���: �ӷ�������inȡ��Ϣ��ʾ������̨.
    new Writer(in).start();
  }
//Reader�̸߳���: �ӿ���̨��ȡ��Ϣд�뵽��������out.
  private class Reader extends Thread{
    OutputStream out;
    public Reader(OutputStream out ) {
      this.out = out;
    }
    public void run(){
      Scanner console = new Scanner(System.in);
      while(true){
        try{
          String str = console.nextLine();
          out.write((str+"\n").getBytes());
          out.flush();
          if(str.startsWith("bye")){
            break;
          }
        }catch(IOException e){
          e.printStackTrace();
          break;
        }
      }
    }
  }
//Writer�̸߳���: �ӷ�������inȡ��Ϣ��ʾ������̨.
  private class Writer extends Thread{
    InputStream in;
    public Writer(InputStream in) {
      this.in = in;
      setDaemon(true);
    }
    public void run(){
      try{
        int b; 
        while((b = in.read())!=-1){
          System.out.write(b);
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}




