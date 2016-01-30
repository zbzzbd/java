package com.tarena.test.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;

public class Server {
  private UserService userService = new UserService();
  public static void main(String[] args) 
    throws IOException {
    Server server = new Server();
    server.start();
  }
  private void start() throws IOException {
    ServerSocket ss = new ServerSocket(8888); 
    while(true){
      Socket s = ss.accept();
      new Service(s).start();
    }
  }
  private class Service extends Thread{
    Socket s ;
    public Service(Socket s ) {
      this.s = s;
    }
    public void run() {
      try{
        ObjectInputStream ois = 
          new ObjectInputStream(s.getInputStream());
        Request req = (Request)ois.readObject();
        Response res = Utils.call(userService, req);
        ObjectOutputStream oos = 
          new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(res);
        oos.flush();
        s.close();
      }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }
  
  public static class UserService{
    int index=1;
    public String login(/*this,*/int id, String pwd){
      if(id==1 && pwd.equals("1")){
        return "tom"+this.index++;
      }
      throw new RuntimeException("µÇÂ¼Ê§°Ü!");
    }
  }
}
