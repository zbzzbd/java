package com.tarena.elts.service;

import com.tarena.elts.entity.User;

/** ����ĺ��Ĺ��ܵĳ���, ����ҵ����: ��¼, ��ʼ����... */
public interface ExamService {
  User login(int id, String pwd)
   throws IdOrPwdException;
}
