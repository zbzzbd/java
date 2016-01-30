package basic.day04;
import java.util.Arrays;
/** 
 * 数组扩展问题
 * 数组对象的长度不能改变!
 * 利用数组的复制变相实现数组的扩展
 * 
 */
public class ArrayExpandDemo {
  public static void main(String[] args) {
    String[] songs = {"忐忑","新贵妃醉酒","水中花"};
    //加入"月亮之上"
    String[] temp = Arrays.copyOf(songs, songs.length+1);
    temp[temp.length-1]="月亮之上";
    songs = temp;
    System.out.println(Arrays.toString(songs));  
    //常见的写法
    songs = Arrays.copyOf(songs, songs.length+1);
    songs[songs.length-1] = "夫妻双双把家还";
    System.out.println(Arrays.toString(songs)); 
  }
}








