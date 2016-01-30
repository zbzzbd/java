package com.tarena.elts.service;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
/** 
 * ���ҵ���ʵ��, ʵ���������ҵ���� login ����
 */
public class ExamServiceImpl implements ExamService {
  private EntityContext entityContext;
  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }
  public User login(int id, String pwd) 
      throws IdOrPwdException {
    
    User user = entityContext.findUserById(id);
    if(user==null){
      throw new IdOrPwdException("ľ����ѽ!");
    }
    if(user.getPasswd().equals(pwd)){
      return user;
    }
    throw new IdOrPwdException("������˰�!"); 
  }
}
