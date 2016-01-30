package com.fuxi.ext;

public class Question {

	// 题目的问题。
	String txt;

	// 选择
	String[] options;

	// 打印题目
	public void print() {
		System.out.println(this.txt);
		// JAVA FOREACH只能在java版本在1.5以上的使用

		// for(int i=0;i<options.length;i++){
		// System.out.print(options[i]+"\t");
		// }
		// Integer.parseInt(String);//把字符串转化为int
		for (String s : options) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

	// 判断正确答案的啊
	// 让子类去重写父类的方法
	public boolean isFlag(char[] answers) {
		return false;
	}
}
