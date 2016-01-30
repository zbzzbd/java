package day04;

import java.util.Scanner;

public class Sample06 {
	public static void main(String[] args){
		System.out.println("欢迎使用XX人员信息系统");
		System.out.println("使用方法如下:");
		System.out.println("添加命令：add \t 显示命令:show \t 查询命令:search 身份证号");
		System.out.println("查询命令:search 身份证号 \t 结束操作:return \t 退出命令: exit");
		while(true){
			Scanner input = new Scanner(System.in);
			String opt = input.next();
			if("add".equals(opt)){
				//执行添加处理
			}else if("show".equals(opt)){
//				执行列表显示
			}else if("search".equals(opt)){
//				执行查询处理
			}else if("exit".equals(opt)){
				break;
			}
		}
	}
}
