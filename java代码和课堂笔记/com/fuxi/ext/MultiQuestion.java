package com.fuxi.ext;

import java.util.Arrays;

public class MultiQuestion extends Question{

	//�ṩһ����׼�Ķ�ѡ��
         char[] answers;
         
         public MultiQuestion(String s, String[] opts, char[] answers){
        	 this.answers=answers;
        	 this.txt=s;
        	 this.options=opts;
         }
  
         @Override
        public boolean isFlag(char[] answers) {      	
        	return Arrays.equals(this.answers, answers);
        }
         
}