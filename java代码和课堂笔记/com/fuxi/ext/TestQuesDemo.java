package com.fuxi.ext;

import java.util.Scanner;

public class TestQuesDemo {

	public static void main(String[] args) {
		Question[] ques = new Question[2];//
		ques[0]=new SingleQuestion("�ϲܼ��ꣿ", 
				new String[] { "A.23", "B.30", "C.45 ",
				"D.26" }, 'D');
		ques[1] = new MultiQuestion("����һ��������������ʱ�������",
				new String[]{"A.ɽ��", "B.����", "C.�� ",
				"D.������" }, new char[]{'A','B'});	
		Scanner scanner = new Scanner(System.in);	
		for(Question q :ques){
			q.print();
			System.out.println("��ѡ����ȷ�𰸣�");
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
