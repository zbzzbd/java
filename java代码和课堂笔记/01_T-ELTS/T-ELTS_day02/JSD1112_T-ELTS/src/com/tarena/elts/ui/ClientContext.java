package com.tarena.elts.ui;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

public class ClientContext implements Serializable {
  private LoginFrame loginFrame;
  private MenuFrame menuFrame;
  private ExamService examService;
  
  public void setLoginFrame(LoginFrame loginFrame) {
    this.loginFrame = loginFrame;
  }
  public void setMenuFrame(MenuFrame menuFrame) {
    //变量的"全限定名"
    com.tarena.elts.ui.ClientContext.this.menuFrame = 
      menuFrame;
  }
  public void setExamService(ExamService examService) {
    this.examService = examService;
  }
  
  public void login(){
    try{
      //从登录界面获取ID和pwd
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPwd();
      //调用业务模型的登录功能
      System.out.println("examService:"+examService);
      User loginUser = examService.login(id, pwd);
      //更新菜单界面, 显示登录用户信息
      menuFrame.updateView(loginUser);
      //如果登录成功就关闭登录界面, 打开菜单界面
      com.tarena.elts.ui.ClientContext.this.
        loginFrame.setVisible(false);
      menuFrame.setVisible(true);
    }catch(IdOrPwdException e){
      //如果登录失败就留在登录界面, 并且在界面上提示错误消息
      loginFrame.showMessage(e.getMessage());
    }
  }
  
  public void exit(JFrame source){  
    int value = JOptionPane.showConfirmDialog(
        source, "亲, 离开吗?");
    if(value==JOptionPane.YES_OPTION){
      source.setVisible(false);
      //System.exit(0)结束当前Java 进程
      System.exit(0);
    }
  }
  
  public void show(){
    loginFrame.setVisible(true);
  }
}






