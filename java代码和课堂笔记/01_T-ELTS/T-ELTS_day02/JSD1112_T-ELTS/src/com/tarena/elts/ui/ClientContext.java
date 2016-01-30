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
    //������"ȫ�޶���"
    com.tarena.elts.ui.ClientContext.this.menuFrame = 
      menuFrame;
  }
  public void setExamService(ExamService examService) {
    this.examService = examService;
  }
  
  public void login(){
    try{
      //�ӵ�¼�����ȡID��pwd
      int id = loginFrame.getUserId();
      String pwd = loginFrame.getPwd();
      //����ҵ��ģ�͵ĵ�¼����
      System.out.println("examService:"+examService);
      User loginUser = examService.login(id, pwd);
      //���²˵�����, ��ʾ��¼�û���Ϣ
      menuFrame.updateView(loginUser);
      //�����¼�ɹ��͹رյ�¼����, �򿪲˵�����
      com.tarena.elts.ui.ClientContext.this.
        loginFrame.setVisible(false);
      menuFrame.setVisible(true);
    }catch(IdOrPwdException e){
      //�����¼ʧ�ܾ����ڵ�¼����, �����ڽ�������ʾ������Ϣ
      loginFrame.showMessage(e.getMessage());
    }
  }
  
  public void exit(JFrame source){  
    int value = JOptionPane.showConfirmDialog(
        source, "��, �뿪��?");
    if(value==JOptionPane.YES_OPTION){
      source.setVisible(false);
      //System.exit(0)������ǰJava ����
      System.exit(0);
    }
  }
  
  public void show(){
    loginFrame.setVisible(true);
  }
}






