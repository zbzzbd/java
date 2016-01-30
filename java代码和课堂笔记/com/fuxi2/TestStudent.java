package com.fuxi2;

public class TestStudent {

	public static void main(String[] args) {

		UnderGraduate u = new UnderGraduate("qiqi", 4, 60, 60, 70);
		u.isPass();
		Graduate g = new Graduate("zhangqi", 5, 50, 60, 70, 90);
		g.isPass2();

	}

}
