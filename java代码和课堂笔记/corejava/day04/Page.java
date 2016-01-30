package day04;

public abstract class Page {
	public void show(int page,int pageSize){
		//ͳ����ҳ��total
		int total = getData().length/pageSize;
		if(getData() == null || getData().length == 0){
			total = 1;
		}else if(getData().length%pageSize != 0){
			total++;
		}
		//��page����ֵ�������飬pageӦ�ô��ڵ���1,С�ڵ���page������
		if(page < 1){
			page = 1;
		}else if(page > total){
			page = total;
		}
		//�����ʾ��Ϣ
		System.out.println("---��ǰҳ"+page+"/"+total+"---");
		//���������Ϣ
		int beginIndex = (page-1)*pageSize;
		for(int i=0;i<pageSize;i++){
			//���һҳ�������pageSize��С����ǰ�˳�
			if(beginIndex+i >= getData().length){
				break;
			}
			System.out.print(getData()[beginIndex+i]+"\t");
		}
	}
	
	public abstract String[] getData();
	
}
