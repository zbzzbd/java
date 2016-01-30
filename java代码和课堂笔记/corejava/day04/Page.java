package day04;

public abstract class Page {
	public void show(int page,int pageSize){
		//统计总页数total
		int total = getData().length/pageSize;
		if(getData() == null || getData().length == 0){
			total = 1;
		}else if(getData().length%pageSize != 0){
			total++;
		}
		//对page参数值做区间检查，page应该大于等于1,小于等于page的整数
		if(page < 1){
			page = 1;
		}else if(page > total){
			page = total;
		}
		//输出提示信息
		System.out.println("---当前页"+page+"/"+total+"---");
		//输出数据信息
		int beginIndex = (page-1)*pageSize;
		for(int i=0;i<pageSize;i++){
			//最后一页如果不够pageSize大小，提前退出
			if(beginIndex+i >= getData().length){
				break;
			}
			System.out.print(getData()[beginIndex+i]+"\t");
		}
	}
	
	public abstract String[] getData();
	
}
