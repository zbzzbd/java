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
    //new Socket(host, port)会发起tcp连接,连接到host:port
    //如果连接成功, 会创建实例s, 如果连接失败会抛出IO异常. 
    //new Socket(host, port)成功, 服务器accept() 也同时
    //执行成功,结束IO Block, 并且返回服务器端Socket实例s 
    Socket s = new Socket("localhost", 8888);
    //客户端的in 连接到服务的out
    InputStream in = s.getInputStream();
    //客户端的out连接到服务器的in
    OutputStream out = s.getOutputStream();
    //Reader线程负责: 从控制台读取信息写入到服务器端out.
    new Reader(out).start();
    //Writer线程负责: 从服务器读in取信息显示到控制台.
    new Writer(in).start();
  }
//Reader线程负责: 从控制台读取信息写入到服务器端out.
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
//Writer线程负责: 从服务器读in取信息显示到控制台.
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




