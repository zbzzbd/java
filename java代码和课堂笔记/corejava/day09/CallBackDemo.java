package day09;

public class CallBackDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		牛人 牛 = new 牛人();
		菜鸟 小菜 = new 菜鸟();
		牛.解决问题(小菜);//注册回调
	}
}
class 牛人{
	//声明注册回调方法
	public void 解决问题(菜鸟 小菜){
		//解决问题。。。。
		小菜.打菜的电话();
	}
}
class 菜鸟{
	//回调方法
	public void 打菜的电话(){
		System.out.println("问题解决了！");
	}
}
