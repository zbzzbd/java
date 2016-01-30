package oop.day03.ext;
/** 单选题继承于选择题.单选题会继承选择题的属性和方法 */
public class SingleQuestion extends Question{
  /** 唯一的单选标准答案 */
  char answer;
  /** 构建一个单选题实例(对象),依赖:题干,选项和一个标准答案 */
  public SingleQuestion(String text, 
      String[] options, char answer) {
    this.text = text;
    this.options = options;
    this.answer = answer;
  }
  /** 覆盖(重写,是修改)父类型的方法,提供具体的检查答案的过程 */
  public boolean check(char[] answers) {
    if(answers==null || answers.length != 1)
      return false;
    return this.answer == answers[0];
  }
}
