package basic.day04;

import java.util.Arrays;

public class CharCounterDemo {
  public static void main(String[] args) {
    String str = "统计一个字符在字符串中的所有位置";
    char key = '字';
    int[] ary =count(str, key);
    System.out.println(Arrays.toString(ary)); 

  }
  public static int[] count(String str, char key){
    //char key = '字';
    //String str = "统计一个字符在字符串中的所有位置";
    int[] count = {}; //new int[0]
    for(int i=0; i<str.length();i++){//迭代字符串的每个字符
      char c = str.charAt(i);
      if(c==key){
        //扩展数组, 
        count = Arrays.copyOf(count, count.length+1);
        //添加序号 i
        count[count.length-1]=i;
      }
    }
    return count;
  }
}
