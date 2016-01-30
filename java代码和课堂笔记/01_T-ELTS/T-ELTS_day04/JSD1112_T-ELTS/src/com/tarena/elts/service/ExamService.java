package com.tarena.elts.service;

import java.util.List;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
import com.tarena.elts.entity.User;

/** ����ĺ��Ĺ��ܵĳ���, ����ҵ����: ��¼, ��ʼ����... */
public interface ExamService {
  User login(int id, String pwd)
   throws IdOrPwdException;

  ExamInfo start();
  
  QuestionInfo getQuestion(int index);

  void saveUserAnswers(int index, 
      List<Integer> userAnswers);

  int send();

  int getScore();  
  
  //User reg(int id, String pwd);
  
  //void add(Question q)
  
}



