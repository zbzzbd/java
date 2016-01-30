package day13;

public class SyncDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table table = new Table();
		table.start();

	}

}

class Table{
	//����p1,p2������Ա������������ȡ��
	Thread p1 = new Thread(){
		public void run(){
			while(true){
				Bean bean = getBean();//ȡ��
				System.out.println("p1�Ե���" + bean);
			}
		}
	};
	Thread p2 = new Thread(){
		public void run(){
			while(true){
				Bean bean = getBean();//ȡ��
				System.out.println("p2�Ե���" + bean);
			}
		}
	};
	int id = 20;
	Object lock = new Object();//����ͬ����������ͬ������������һ��Object����

	//ȡ��
	public Bean getBean(){
		int n ;
		synchronized(lock){
			if (id == 0){
				throw new RuntimeException("���Թ��ˣ�");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n = id--;
			Bean b = new Bean(id);
			Thread.yield();
			return b;
		}
	}
	public void start(){
		p1.start();
		p2.start();
	}
}

class Bean{
	int id;
	public Bean(int id){
		this.id = id;
	}
	public String toString(){
		return "bean:" + id;
	}
}