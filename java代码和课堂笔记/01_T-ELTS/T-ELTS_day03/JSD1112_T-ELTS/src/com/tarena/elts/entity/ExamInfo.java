package com.tarena.elts.entity;

import java.io.Serializable;

/**
 * ������Ϣֵ����.
 * ��ֵ����
 * @author Robin
 */
public class ExamInfo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7171922215075641740L;
  /** ���Կ�Ŀ */
  private String title;
  /** ���� */
  private User user;
  /**
   * ����Ϊ��λ
   */
  private int timeLimit;
  
  private int questionCount;
  
  public ExamInfo() {
  }

  public ExamInfo(String title, User user, int timeLimit, int questionCount) {
    super();
    this.title = title;
    this.user = user;
    this.timeLimit = timeLimit;
    this.questionCount = questionCount;
  }

  @Override
  public String toString() {
    if(user==null)
      return "����Ϣ!";
    return "����: "+user.getName() + 
    "    ���: " + user.getId() + 
    "    ����ʱ��: " + timeLimit + "����" + 
    "    ���Կ�Ŀ: " + title + 
    "    ��Ŀ����: " + questionCount;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getTimeLimit() {
    return timeLimit;
  }

  public void setTimeLimit(int timeLimit) {
    this.timeLimit = timeLimit;
  }

  public int getQuestionCount() {
    return questionCount;
  }

  public void setQuestionCount(int questionCount) {
    this.questionCount = questionCount;
  }
  
  
  
}
