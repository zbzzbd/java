package com.tarena.test.net;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;
//状态==数据的值
public class Client {
  public static void main(String[] args) {
    Request req = new Request();
    req.setMethod("login");
    req.setParamTypes(
        new Class[]{int.class, String.class});
    req.setParams(new Object[]{1,"1"});
    Response res =
      Utils.remoteCall("localhost", 8888, req);
    if(res.isSuccess()){
      System.out.println(res.getValue());
    }else{
      res.getException().printStackTrace();
    }
    
  }
}
