package com.tarena.elts.net;

import java.io.Serializable;
import java.util.Arrays;

public class Request implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1173799408673555467L;
  /** �ỰID */
  private String sessionID;
  /** ������ */
  private String method;
  /** ���������б� */
  private Class[] paramTypes;
  /** �����б� */
  private Object[] params;
  public Request() {
  }
  public Request(String method,
      Class[] paramTypes, Object[] params) {
    this.method = method;
    this.paramTypes = paramTypes;
    this.params = params;
  }
  public String getMethod() {
    return method;
  }
  public void setMethod(String method) {
    this.method = method;
  }
  public Object[] getParams() {
    return params;
  }
  public void setParams(Object[] params) {
    this.params = params;
  }
  public Class[] getParamTypes() {
    return paramTypes;
  }
  public void setParamTypes(Class[] paramTypes) {
    this.paramTypes = paramTypes;
  }
  public String getSessionID() {
    return sessionID;
  }
  public void setSessionID(String sessionID) {
    this.sessionID = sessionID;
  }
  @Override
  public String toString() {
    return "["+sessionID + ","+method+
    Arrays.toString(paramTypes)+
    Arrays.toString(params)+"]";
  }
}
