package day04;

public class Dept extends Page{
	public String[] depts = {"����1","����2","����3","����4","����5","����6","����7","����8"};

	@Override
	public String[] getData() {
		return depts;
	}
	
}
