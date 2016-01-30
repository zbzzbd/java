package com.tarena.elts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.elts.entity.EntityContext;
import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.Question;
import com.tarena.elts.entity.QuestionInfo;
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
      loginUser = user;
      return user;
    }
    throw new IdOrPwdException("密码错了吧!"); 
  }
  /** 考卷, 考卷是考题的线性表集合 */
  private List<QuestionInfo> paper = 
    new ArrayList<QuestionInfo>();
  private User loginUser;
  private void createPaper(){
    Random random = new Random();
    int i = 0;
    for(int level=Question.LEVEL1; 
      level<=Question.LEVEL10; level++){
      List<Question> list = 
        entityContext.findQuestions(level);
      Question q1 = 
        list.remove(random.nextInt(list.size()));
      Question q2 = 
        list.remove(random.nextInt(list.size()));
      paper.add(new QuestionInfo(i++,q1));
      paper.add(new QuestionInfo(i++,q2));
    }
  }
  
  public ExamInfo start() {
    if(finish){
      throw new RuntimeException("考试已经结束!");
    }
    //组织考卷
    createPaper();
    //创建考试信息对象, 组织考试信息
    ExamInfo examInfo = new ExamInfo();
    examInfo.setQuestionCount(paper.size());
    examInfo.setTimeLimit(entityContext.getTimeLimit());
    examInfo.setTitle(entityContext.getTitle());
    examInfo.setUser(loginUser);
    //返回考试信息
    return examInfo;
  }
  
  public QuestionInfo getQuestion(int index) {
    return paper.get(index); 
  }
  
  public void saveUserAnswers(
      int index, List<Integer> userAnswers) {
    QuestionInfo q = paper.get(index);
    q.getUserAnswers().clear();
    q.getUserAnswers().addAll(userAnswers);
  }
  private int score;
  private boolean finish = false;
  public int send() {
    if(finish){
      throw new RuntimeException("考试已经结束!");
    }
    score = 0;
    for (QuestionInfo info : paper) {
      Question q = info.getQuestion();
      List<Integer> answers = q.getAnswers();
      List<Integer> userAnswers = info.getUserAnswers();
      if(answers.equals(userAnswers)){
        score+=q.getScore();
      }
    }
    finish = true;
    return score;
  }
  public int getScore() {
    if(! finish){
      throw new RuntimeException("还没有考试!");
    }
    return score;
  }
}




