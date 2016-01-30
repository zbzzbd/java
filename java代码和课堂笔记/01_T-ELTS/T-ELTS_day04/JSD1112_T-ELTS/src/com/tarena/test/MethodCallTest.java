package com.tarena.test;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;
/** 
 * 方法调用测试, 用来测试 Utils 中的方法call()
 * 这个利用反射API调用了 某对象的某方法
 * 这个方法用于实现 服务器端调用业务层实例的业务方法.
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
      System.out.println("欢迎"+res.getValue()); 
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
      throw new RuntimeException("登录失败!");
    }
  }
}

