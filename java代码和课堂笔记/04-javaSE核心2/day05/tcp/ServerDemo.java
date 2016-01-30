package javase2.day05.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** TCP 服务器原型演示 */
public class ServerDemo {
  public static void main(String[] args) 
    throws IOException {
    ServerDemo server = new ServerDemo();
    server.start();
  }
  public void start() throws IOException{
    //利用ServerSocket绑定当前主机(Host)的服务端口
    //将占用8888端口提供服务, 端口不能重复占用(绑定) 
    //端口号: 0~65535, 1K 以下留给系统使用.
    //如果绑定失败或抛出异常, 绑定成功就创建了对象ss
    ServerSocket ss = new ServerSocket(8888);
    while(true){
      //ss.accept()是开始等待对8888端口的监听
      //ss.accept()是IO Block方法, 等待客户端的连接
      //如果有客户端连接进来, IO就完成, 结束Block
      //返回一个Socket实例s,代表对客户端的连接s中包含(in,out)
      //in 代表客户端到服务器的流, out代表服务器到客户端的流
      Socket s = ss.accept();
      //启动客户端服务线程, 处理这个客户的请求和响应
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
        out.write("你要点啥?\n".getBytes());
        out.flush();
        while(true){
          String str = s.nextLine();
          if(str.equals("鱼丸")){
            out.write("木有啊?\n".getBytes());
            out.flush();
          }else if(str.startsWith("bye")){
            out.write("亲,再见呀?\n".getBytes());
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






