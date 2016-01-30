package com.fuxi.ext;

public class SingleQuestion extends Question {
	// ��׼�Ĵ�
	char answer;

	public SingleQuestion(String s, String[] opts, char answer) {
		this.txt = s;
		this.options = opts;
		this.answer = answer;
	}
	// ��д�����isFlag
	@Override
	public boolean isFlag(char[] answers) {
		if (answers == null || answers.length != 1) {
			return false;
		}
		return this.answer == answers[0];
	}

}
