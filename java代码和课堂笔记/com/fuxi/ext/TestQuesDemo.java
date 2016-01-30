package com.fuxi.ext;

import java.util.Scanner;

public class TestQuesDemo {

	public static void main(String[] args) {
		Question[] ques = new Question[2];//
		ques[0]=new SingleQuestion("老曹几岁？", 
				new String[] { "A.23", "B.30", "C.45 ",
				"D.26" }, 'D');
		ques[1] = new MultiQuestion("你这一生中让你难忘的时刻在哪里？",
				new String[]{"A.山洞", "B.冰窖", "C.家 ",
				"D.王府井" }, new char[]{'A','B'});	
		Scanner scanner = new Scanner(System.in);	
		for(Question q :ques){
			q.print();
			System.out.println("请选择正确答案：");
			String s = scanner.nextLine();
			char [] answer = s.toCharArray();
			if(q.isFlag(answer)){
				System.out.println("OK");
			}else{
				System.out.println("ERROR");		
			}	
		}
		
		
		
	}

}
