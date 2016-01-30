package day04;

public class Dept extends Page{
	public String[] depts = {"部门1","部门2","部门3","部门4","部门5","部门6","部门7","部门8"};

	@Override
	public String[] getData() {
		return depts;
	}
	
}
