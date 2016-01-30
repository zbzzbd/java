package com.fuxi2;

public class UnderGraduate extends Student {

	public UnderGraduate(String name, int id, double ChineseScore,
			double EnglishScore, double MathScore) {
		this.name = name;
		this.id = id;
		this.EnglishScore = EnglishScore;
		this.ChineseScore = ChineseScore;
		this.MathScore = MathScore;
	}

	public void isPass() {
		if ((super.getEnglishScore() + super.getChineseScore() + super
				.getMathScore()) / 3 >= 60) {
			System.out.println(super.getName()+"Í¨¹ý");
		} else {
			System.out.println("NO");
		}
	}

}
