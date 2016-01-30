package com.tarena.elts.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/** ϵͳ������ */
public class Utils {
  /** 
   * Զ�̷�������
   * @param host Զ������
   * @param port �˿ں�
   * @param req ��������
   * @return ���н��
   */
  public static Response remoteCall( String host,
      int port, Request req){
    try{
      Socket s = new Socket(host, port);//��������
      //��������
      ObjectOutputStream out = 
        new ObjectOutputStream(s.getOutputStream());
      System.out.println("remoteCall request:"+req);
      out.writeObject(req);
      out.flush();
      //��ȡ��Ӧ
      ObjectInputStream in=
        new ObjectInputStream(s.getInputStream());
      Response res = (Response)in.readObject();
      System.out.println("remoteCall Response:"+res);
      s.close();
      return res;
    }catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  /**
   * ���ö���ķ���
   * @param obj �Ǳ����ö���
   * @param req ������ֵ����,����������,���������б�,�����б�
   * @return  Response ����, �Ƿ���ֵ, �쳣�Ĵ��
   **/
  public static Response call(Object obj, Request req){
    Response res = new Response();
    try {
      Class cls=obj.getClass();
      Method method = cls.getDeclaredMethod(
          req.getMethod(), req.getParamTypes());
      Object val = method.invoke(obj, req.getParams());
      res.setValue(val);
      return res;
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      res.setException((Exception)e.getTargetException());
    } catch (Exception e) {
      e.printStackTrace();
      res.setException(e);
    }
    return res;
  }
}






