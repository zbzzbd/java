package com.tarena.test;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;
import com.tarena.elts.ui.ClientContext;
import com.tarena.elts.ui.LoginFrame;
import com.tarena.elts.ui.MenuFrame;

public class LoginProcessTest {
  public static void main(String[] args) {
    LoginFrame loginFrame = new LoginFrame();
    MenuFrame menuFrame = new MenuFrame();
    ClientContext clientContext = new ClientContext();
    
    loginFrame.setClientContext(clientContext);
    clientContext.setLoginFrame(loginFrame);
    clientContext.setMenuFrame(menuFrame);
    
    ExamService examService = new ExamService(){
      public User login(int id, String pwd) 
        throws IdOrPwdException {
        if(id==1000 && pwd.equals("1000")){
          return new User("Robin", 1, "1000");
        }
        throw new IdOrPwdException("Ç×,´íÁË!");
      }
      public QuestionInfo getQuestion(int index) {
        // TODO Auto-generated method stub
        return null;
      }
      public ExamInfo start() {
        // TODO Auto-generated method stub
        return null;
      }
      public void saveUserAnswers(int index, List<Integer> userAnswers) {
        // TODO Auto-generated method stub
        
      }
      public int send() {
        // TODO Auto-generated method stub
        return 0;
      }
      public int getScore() {
        // TODO Auto-generated method stub
        return 0;
      }
    };
    
    clientContext.setExamService(examService);
    clientContext.show();
  }
}
