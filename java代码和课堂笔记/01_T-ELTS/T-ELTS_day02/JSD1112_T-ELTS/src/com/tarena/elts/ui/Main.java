package com.tarena.elts.ui;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.ExamServiceImpl;
import com.tarena.elts.util.Config;

/** 软件入口 类 */
public class Main {
  public static void main(String[] args) {
    LoginFrame loginFrame = new LoginFrame();
    MenuFrame menuFrame = new MenuFrame();
    ExamFrame examFrame = new ExamFrame();
    
    ClientContext clientContext = new ClientContext();
    
    ExamServiceImpl examService = new ExamServiceImpl();
    Config config = new Config("client.properties");
    EntityContext entityContext = 
      new EntityContext(config);
    loginFrame.setClientContext(clientContext);
    clientContext.setLoginFrame(loginFrame);
    clientContext.setExamService(examService);
    clientContext.setMenuFrame(menuFrame);
    
    examService.setEntityContext(entityContext);
    
    clientContext.show();
  }
}
