package com.fuxi.ext;

public class SingleQuestion extends Question {
	// 标准的答案
	char answer;

	public SingleQuestion(String s, String[] opts, char answer) {
		this.txt = s;
		this.options = opts;
		this.answer = answer;
	}
	// 重写父类的isFlag
	@Override
	public boolean isFlag(char[] answers) {
		if (answers == null || answers.length != 1) {
			return false;
		}
		return this.answer == answers[0];
	}

}
