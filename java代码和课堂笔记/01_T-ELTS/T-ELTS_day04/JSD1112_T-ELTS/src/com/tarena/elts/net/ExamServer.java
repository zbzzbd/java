package com.tarena.elts.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.util.Config;

/**
 * ���Է�����, 
 * 
 *  */
public class ExamServer {
  
  private Config config;
  /** �����б�, ÿ��SID��Ӧһ�� ExamService ʵ��, 
   * ÿ���ͻ���Ӧһ��SID */
  Map<String, ExamService> serviceMap = 
    new HashMap<String, ExamService>();
  private EntityContext entityContext;
  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }
  public ExamServer() {
  }
  public void setConfig(Config config) {
    this.config = config;
  }
  public void start(){
    int port = config.getInt("ServerPort");
    try {
      ServerSocket ss = new ServerSocket(port);
      while(true){
        //�ȴ��ͻ��˵�����
        Socket s = ss.accept();
        new Service(s).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  class Service extends Thread{
    Socket s;
    public Service(Socket s) {
      this.s = s;
    }
    @Override
    public void run() {
      try {
//      ��������
        ObjectInputStream in = 
          new ObjectInputStream(s.getInputStream());
        Request req = (Request)in.readObject();
        //����-
        //String obj = "ABCD";
        //�����û�����req, �ҵ���ӦSessionID �Ŀ��Է������
        //һ�����Է�������Ӧ��һ�����Կͻ���(һ������)
        //�������req �� û��SessionID getService()������
        //�����µ�SessionID��ExamService ʵ��
        ExamService service = getService(req);
        Response res = Utils.call(service, req);
        res.setSessionID(req.getSessionID());
        //������Ӧ
        ObjectOutputStream out = 
          new ObjectOutputStream(s.getOutputStream());
        out.writeObject(res);
        //�Ͽ�����
        s.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  

  private ExamService getService(Request req) {
    String sid = req.getSessionID();
    if(sid==null){//���û��SID �ʹ����µ�
      sid = UUID.randomUUID().toString();
      req.setSessionID(sid);
    }
    ExamService service = serviceMap.get(sid);
    if(service==null){//��һ�η��ʷ���, ��Ҫ�����µ�service
      ExamServiceImpl serviceImpl = 
        new ExamServiceImpl();
      serviceImpl.setEntityContext(entityContext);
      serviceMap.put(sid, serviceImpl);
      service = serviceImpl;
    }
    return service;
  }

  /** ���������� */
  public static void main(String[] args) {
    ExamServer server = new ExamServer();
    Config config = new Config("server.properties");
    EntityContext entityContext = 
      new EntityContext(config);
    server.setConfig(config);
    server.setEntityContext(entityContext);
    server.start();
  }
}



