package com.tarena.test;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;
/** 
 * �������ò���, �������� Utils �еķ���call()
 * ������÷���API������ ĳ�����ĳ����
 * �����������ʵ�� �������˵���ҵ���ʵ����ҵ�񷽷�.
 **/
public class MethodCallTest {
  public static void main(String[] args) {
    Request req = new Request();
    req.setMethod("login");
    req.setParamTypes(
        new Class[]{int.class, String.class});
    req.setParams(new Object[]{1,"2"});
    Object obj = new UserService();
    Response res = Utils.call(obj, req);
    //Object val=method.invoke(obj, req.getParams());
    if(res.isSuccess()){
      System.out.println("��ӭ"+res.getValue()); 
    }else{
      res.getException().printStackTrace();
    }
  }
  public static class UserService{
    int index=1;
    public String login(/*this,*/int id, String pwd){
      if(id==1 && pwd.equals("1")){
        return "tom"+this.index++;
      }
      throw new RuntimeException("��¼ʧ��!");
    }
  }
}

