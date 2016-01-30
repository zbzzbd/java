package com.tarena.elts.service;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.User;
/** 
 * 软件业务层实现, 实现软件核心业务功能 login 方法
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
      throw new IdOrPwdException("木有人呀!");
    }
    if(user.getPasswd().equals(pwd)){
      return user;
    }
    throw new IdOrPwdException("密码错了吧!"); 
  }
}
