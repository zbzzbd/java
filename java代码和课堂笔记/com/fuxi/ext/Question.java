package com.fuxi.ext;

public class Question {

	// ��Ŀ�����⡣
	String txt;

	// ѡ��
	String[] options;

	// ��ӡ��Ŀ
	public void print() {
		System.out.println(this.txt);
		// JAVA FOREACHֻ����java�汾��1.5���ϵ�ʹ��

		// for(int i=0;i<options.length;i++){
		// System.out.print(options[i]+"\t");
		// }
		// Integer.parseInt(String);//���ַ���ת��Ϊint
		for (String s : options) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

	// �ж���ȷ�𰸵İ�
	// ������ȥ��д����ķ���
	public boolean isFlag(char[] answers) {
		return false;
	}
}
