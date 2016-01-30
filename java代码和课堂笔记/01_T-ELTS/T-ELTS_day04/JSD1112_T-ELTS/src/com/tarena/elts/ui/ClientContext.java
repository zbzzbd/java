package com.tarena.elts.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;
import com.tarena.elts.service.ExamService;
import com.tarena.elts.service.IdOrPwdException;

public class ClientContext implements Serializable {
  private static final long serialVersionUID = 6223839803053176781L;
  
  private LoginFrame loginFrame;
  private MenuFrame menuFrame;
  private ExamFrame examFrame;
  private WelcomeWindow welcomeWindow;
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
  public void setExamFrame(ExamFrame examFrame) {
    this.examFrame = examFrame;
  }
  public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
    this.welcomeWindow = welcomeWindow;
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
      e.printStackTrace();
      //�����¼ʧ�ܾ����ڵ�¼����, �����ڽ�������ʾ������Ϣ
      loginFrame.showMessage(e.getMessage());
    }catch(NumberFormatException e){
      e.printStackTrace();
      loginFrame.showMessage("��ű���������!");
    }catch (Exception e) {
      e.printStackTrace();
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
    welcomeWindow.setVisible(true);
    final Timer timer = new Timer();
    timer.schedule(new TimerTask(){
      public void run() {
        welcomeWindow.setVisible(false);
        loginFrame.setVisible(true);
        timer.cancel();
      }
    }, 2000);
  }
  
  public void start() {
    try{
      //����ҵ��㷽����ʼ����, ���ؿ�����ϸ��Ϣ
      ExamInfo examInfo = examService.start();
      //����ҵ��㷽��ȡ�ص�һ����
      QuestionInfo questionInfo = 
        examService.getQuestion(0);
      //���ֵ�ǰ��Ŀ״̬
      currentQuestionInfo = questionInfo;
      //���ֿ�����Ϣ״̬
      this.examInfo = examInfo;
      //����ExamFrame��ʾ������Ϣ, �͵�һ����
      examFrame.updateView(examInfo, questionInfo);
      //�رղ˵�����
      menuFrame.setVisible(false);
      //�򿪿��Խ���
      examFrame.setVisible(true);
      startTimer();
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
  private QuestionInfo currentQuestionInfo;
  private ExamInfo examInfo;
  
  public void next(){
    try{
      //ȡ�õ�ǰ�����
      int index = currentQuestionInfo.getQuestionIndex();
      //���浱ǰ������û��𰸵�ҵ���
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //ȡ����һ��Ŀ
      QuestionInfo questionInfo = 
        examService.getQuestion(index+1);
      currentQuestionInfo = questionInfo;
      //���¿��Խ���, ��ʾ��һ��Ŀ
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  public void prev(){
    try{
      //ȡ�õ�ǰ�����
      int index = currentQuestionInfo.getQuestionIndex();
      //���浱ǰ������û��𰸵�ҵ���
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //ȡ����һ��Ŀ
      QuestionInfo questionInfo = 
        examService.getQuestion(index-1);
      currentQuestionInfo = questionInfo;
      //���¿��Խ���, ��ʾ��һ��Ŀ
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
   
  /** ���� */
  public void send() { 
    int val = JOptionPane.showConfirmDialog(
        examFrame, "��ľ�д��㽻��?");
    if(val==JOptionPane.YES_OPTION){
      gameOver();
    }
  }
  
  public void gameOver() { 
    try {
      
      int index = currentQuestionInfo.getQuestionIndex();
      //��ȡ�����û���
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //�����û���
      examService.saveUserAnswers(index, userAnswers);
      //������
      int score = examService.send();
      //��ʾ����
      timer.cancel();
      JOptionPane.showMessageDialog(
          examFrame, "����:"+score);
      //�رտ��Խ���
      examFrame.setVisible(false);
      //���ز˵�����
      menuFrame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }

  
  public void result() {
    try{
      
      int score = examService.getScore();
      JOptionPane.showMessageDialog(
          menuFrame, "����:"+score);
      
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          menuFrame, e.getMessage());
    }
  }
  private Timer timer;
  private void startTimer(){
    timer = new Timer();
    long start = System.currentTimeMillis();
    final long end = examInfo.getTimeLimit()*60*1000+start;
    timer.schedule(new TimerTask(){
      @Override
      public void run() {
        long show = end - System.currentTimeMillis();
        long h = show/1000/60/60;
        long m = show/1000/60%60;
        long s = show/1000%60;
        examFrame.updateTime(h, m, s);
      }
    }, 0, 1000);
    timer.schedule(new TimerTask(){
      @Override
      public void run() {

        gameOver();
      }
    }, new Date(end));
  }
  
}






