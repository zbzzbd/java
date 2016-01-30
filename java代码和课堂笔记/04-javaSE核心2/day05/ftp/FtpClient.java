package javase2.day05.ftp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * ftp �ͻ��� ����ʹ������ ls pwd get
 */

public class FtpClient {
  public static void main(String[] args) 
  throws IOException{
    FtpClient client = new FtpClient();
    client.open();
  }
  public void open() throws IOException{
    Socket s = new Socket("localhost", 9000);
    InputStream in = s.getInputStream();
    OutputStream out = s.getOutputStream();
    //����ͻ��˶Է�����������
    new RequestProcess(out).start();
    //����������ķ�����Ϣ
    new ResponseProcess(in).start();
  }
//����ͻ��˶Է�����������
  class RequestProcess extends Thread{
    OutputStream out;
    public RequestProcess(OutputStream out) {
      this.out = out;
    }
    public void run() {
      try{
        Scanner sc = new Scanner(System.in);
        while(true){
          String s = sc.nextLine();
          IOUtils.println(out, s);
          if(s.equals("bye")){
            System.exit(0);
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
  class ResponseProcess extends Thread{
    InputStream in;
    public ResponseProcess(InputStream in) {
      this.in = in;
    }
    public void run() {
      try{
        while(true){
          String header = IOUtils.readLine(in);
          if(header.startsWith("text,")){
            show(header,in);
          }else if(header.startsWith("file,")){
            save(header, in);
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
  public void show(String header, InputStream in) 
    throws IOException {
    int n = Integer.parseInt(header.split(",")[1]);
    for(int i=0; i<n; i++){
      String s = IOUtils.readLine(in);
      System.out.println(s);
    }
  }
  public void save(String header, InputStream in) 
    throws IOException{
    File dir = new File("ftp");
    if(!dir.exists()){
      dir.mkdir();
    }
    //header: file,10,filename
    String[] data = header.split(",");
    long length = Long.parseLong(data[1]);
    String filename = data[2];
    File file = new File(dir, filename);
    BufferedOutputStream out = 
      new BufferedOutputStream(
          new FileOutputStream(file));
    for(long i=0; i<length; i++){
      int b = in.read();
      out.write(b);
    }
    out.close();
  }
  
  
}




