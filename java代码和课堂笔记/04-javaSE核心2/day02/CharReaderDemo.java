package javase2.day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/** 文本文件的读取  */
public class CharReaderDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "demo.txt"; 
    InputStreamReader in = 
      new InputStreamReader(
          new FileInputStream(file), "UTF-8");
    //read()从底层的文件流中读取byte数据, 按照"utf-8" 解码
    //为字符, 填充到int结果的低16位, 高位保持16个0, 
    //正常结果范围: 0000 0000 ~ 0000 ffff, 返回-1表示读取结束! 
    int ch;
    while((ch=in.read())!=-1){
      System.out.print(
          Integer.toHexString(ch)+"("+(char)ch+")");
    }
    in.close();
  }

}
