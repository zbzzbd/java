package com.tarena.test;

import com.tarena.elts.net.Request;
import com.tarena.elts.net.Response;
import com.tarena.elts.net.Utils;

public class ExamServerTest {
  public static void main(String[] args) {
    Request req = new Request();
    req.setMethod("login");
    req.setParamTypes(
        new Class[]{int.class, String.class});
    req.setParams(new Object[]{1001,"1234"});
    Response res =
      Utils.remoteCall("localhost", 9091, req);
    String sid = res.getSessionID();
    if(res.isSuccess()){
      System.out.println(res.getValue());
    }else{
      res.getException().printStackTrace();
    }
    req = new Request();
    req.setMethod("start");
    req.setParamTypes(
        new Class[]{});
    req.setParams(new Object[]{});
    req.setSessionID(sid);
    res=Utils.remoteCall("localhost", 9091, req);
    if(res.isSuccess()){
      System.out.println(res.getValue());
    }else{
      res.getException().printStackTrace();
    }
    //
  }
}
