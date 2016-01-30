package com.tarena.elts.service;

import com.tarena.elts.entity.User;

/** 软件的核心功能的抽象, 核心业务功能: 登录, 开始考试... */
public interface ExamService {
  User login(int id, String pwd)
   throws IdOrPwdException;
}
