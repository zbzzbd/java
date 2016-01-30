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
    //变量的"全限定名"
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
      e.printStackTrace();
      //如果登录失败就留在登录界面, 并且在界面上提示错误消息
      loginFrame.showMessage(e.getMessage());
    }catch(NumberFormatException e){
      e.printStackTrace();
      loginFrame.showMessage("编号必须是数字!");
    }catch (Exception e) {
      e.printStackTrace();
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
      //调用业务层方法开始考试, 返回考试详细信息
      ExamInfo examInfo = examService.start();
      //调用业务层方法取回第一道题
      QuestionInfo questionInfo = 
        examService.getQuestion(0);
      //保持当前题目状态
      currentQuestionInfo = questionInfo;
      //保持考试信息状态
      this.examInfo = examInfo;
      //更新ExamFrame显示考试信息, 和第一道题
      examFrame.updateView(examInfo, questionInfo);
      //关闭菜单界面
      menuFrame.setVisible(false);
      //打开考试界面
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
      //取得当前的题号
      int index = currentQuestionInfo.getQuestionIndex();
      //保存当前考题的用户答案到业务层
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //取得下一题目
      QuestionInfo questionInfo = 
        examService.getQuestion(index+1);
      currentQuestionInfo = questionInfo;
      //更新考试界面, 显示下一题目
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
  public void prev(){
    try{
      //取得当前的题号
      int index = currentQuestionInfo.getQuestionIndex();
      //保存当前考题的用户答案到业务层
      List<Integer> userAnswers= 
        examFrame.getUserAnswers(); 
      examService.saveUserAnswers(index, userAnswers);
      //取得下一题目
      QuestionInfo questionInfo = 
        examService.getQuestion(index-1);
      currentQuestionInfo = questionInfo;
      //更新考试界面, 显示上一题目
      examFrame.updateView(examInfo, questionInfo);
    }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          examFrame, e.getMessage());
    }
  }
   
  /** 交卷 */
  public void send() { 
    int val = JOptionPane.showConfirmDialog(
        examFrame, "有木有打算交卷?");
    if(val==JOptionPane.YES_OPTION){
      gameOver();
    }
  }
  
  public void gameOver() { 
    try {
      
      int index = currentQuestionInfo.getQuestionIndex();
      //获取最后的用户答案
      List<Integer> userAnswers = 
        examFrame.getUserAnswers();
      //保存用户答案
      examService.saveUserAnswers(index, userAnswers);
      //交卷处理
      int score = examService.send();
      //显示分数
      timer.cancel();
      JOptionPane.showMessageDialog(
          examFrame, "分数:"+score);
      //关闭考试界面
      examFrame.setVisible(false);
      //返回菜单界面
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
          menuFrame, "分数:"+score);
      
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






