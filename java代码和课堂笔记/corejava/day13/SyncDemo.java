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
	//定义p1,p2两个成员变量，两个人取豆
	Thread p1 = new Thread(){
		public void run(){
			while(true){
				Bean bean = getBean();//取豆
				System.out.println("p1吃掉了" + bean);
			}
		}
	};
	Thread p2 = new Thread(){
		public void run(){
			while(true){
				Bean bean = getBean();//取豆
				System.out.println("p2吃掉了" + bean);
			}
		}
	};
	int id = 20;
	Object lock = new Object();//定义同步监视器（同步锁），任意一个Object对象

	//取豆
	public Bean getBean(){
		int n ;
		synchronized(lock){
			if (id == 0){
				throw new RuntimeException("豆吃光了！");
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