package com.fuxi2;
public class Graduate extends Student {
	double Score;
	public Graduate(String name, int id, double ChineseScore,
			double EnglishScore, double MathScore, double Score) {
		this.name = name;
		this.id = id;
		this.EnglishScore = EnglishScore;
		this.ChineseScore = ChineseScore;
		this.MathScore = MathScore;
		this.Score = Score;
	}
         
	public void isPass2() {
		if ((super.getEnglishScore() + super.getChineseScore()
				+ super.getMathScore() + this.Score) / 4 >= 80) {
			System.out.println(super.getName() + " ͨ��");
		} else {
			System.out.println(super.getName() + " NO");
		}
	}

}
