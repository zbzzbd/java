package day09;
import java.io.*;
public class InputStreamDemo {
	public static void main(String[] args) {
		//file.txt: 41 42 43 c3 e6 b3 af...
		//输入流是单向的，只能流入
		try{
			InputStream in = 
				new FileInputStream("file.txt");
			int b = in.read();
			System.out.println(Integer.toHexString(b));//41
			b = in.read();
			System.out.println(Integer.toHexString(b));//42
			b = in.read();
			System.out.println(Integer.toHexString(b));//43

			b = in.read();
			System.out.println(Integer.toHexString(b));
			b = in.read();
			System.out.println(Integer.toHexString(b));
			
			byte[] buf = new byte[in.available()];
			in.read(buf);
			String s = new String(buf, "gbk");
			System.out.print(s);
			
			//System.out.println(Math.pow(2, 16));
			
			
//			int b = 0;
//			while ((b = in.read()) != -1){
//				System.out.println(Integer.toHexString(b));
//			}
//			byte[] buffer = new byte[1024] ;
//			int n = 0;
//			while ((n = in.read(buffer)) != -1){
//				String s = new String(buffer, "gbk");
//				System.out.println(s);
//			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
