package oop.day03.ext;

import java.util.Scanner;

public class PaperDemo {
  public static void main(String[] args) {
    //paper 考卷, 考卷是选择题的集合(数组)
    Question[] paper = {null, null};//new Question[2];
    paper[0]=new SingleQuestion("如何买火车票靠谱?",
        new String[]{"A.电话","B.网上","C.黄牛","D.画的"}, 
        'A');
    paper[1]=new MultiQuestion("那几位是达内老师?",
        new String[]{"A.宁丽鹃","B.刘苍松",
                    "C.程祖红", "D.孙悟空"},
        new char[]{'A','B','C'});
    Scanner console = new Scanner(System.in);
    for(int i=0; i<paper.length; i++){
      Question q = paper[i];
      q.print();//打印试题
      System.out.print("请选择:");
      String str = console.nextLine();//等待用户答案
      char[] answers = str.toCharArray();//转换答案为数组
      //方法是动态绑定到对象, 有具体对象决定执行那个方法
      if(q.check(answers)){//检查用户答案
        System.out.println("给力呀!");
      }else{
        System.out.println("亲, 要努力呀!");
      }
    }    
  }

}
