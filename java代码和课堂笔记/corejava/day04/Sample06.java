package day04;

import java.util.Scanner;

public class Sample06 {
	public static void main(String[] args){
		System.out.println("��ӭʹ��XX��Ա��Ϣϵͳ");
		System.out.println("ʹ�÷�������:");
		System.out.println("������add \t ��ʾ����:show \t ��ѯ����:search ���֤��");
		System.out.println("��ѯ����:search ���֤�� \t ��������:return \t �˳�����: exit");
		while(true){
			Scanner input = new Scanner(System.in);
			String opt = input.next();
			if("add".equals(opt)){
				//ִ����Ӵ���
			}else if("show".equals(opt)){
//				ִ���б���ʾ
			}else if("search".equals(opt)){
//				ִ�в�ѯ����
			}else if("exit".equals(opt)){
				break;
			}
		}
	}
}
