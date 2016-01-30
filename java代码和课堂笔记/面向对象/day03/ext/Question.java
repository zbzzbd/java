package oop.day03.ext;
/** 选择题 */
public class Question {
  /** 题干 */
  String text;
  /** 选项 */
  String[] options;
  /** 打印当前题目 */
  public void print(/*Question this*/){
    //this 实际引用的是单选题实例
    System.out.println(this.text);
    for(int i=0;i<this.options.length; i++){
      System.out.print(options[i]+"\t");
    }
    System.out.println(); 
  }
  /** 检查答案, answers 代表用户填写的答案
   * 这个方法不能 确定具体的检查答案的逻辑, 
   * 需要由具体型覆盖方法*/
  public boolean check(char[] answers){
    return false;//这个false表示用户答案是错误的,应该
    //由子类型提供具体的检查答案的方法(叫"方法的覆盖")
  }
}
