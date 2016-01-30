package day01;

public class Sample02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		test1();
		test2();

	}
	
	public static void test1(){
		int[] arr = new int[10];
		System.out.println(arr[2]);
		String[] strArr = new String[5];
		System.out.println(strArr[1]);
	}
	
	public static void test2(){
		String[] strArr = new String[5];
		strArr[0] = "tom";
		strArr[1] = "jack";
		System.out.println("数组空间大小:"+strArr.length);
//		for(int i=0;i<strArr.length;i++){
//			System.out.println(strArr[i]);
//		}
		//jdk5.0开始支持的新循环
		for(String str:strArr){
			System.out.println(str);
		}
		
	}

}
