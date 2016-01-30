package oop.day03.ext;

import java.util.Arrays;

/** 多项选择题, 继承表示"是"的关系: 多选题是选择题 */
public class MultiQuestion extends Question {
  /** 对选题标准答案 */
  char[] answers;

  public MultiQuestion(String text, 
      String[] options, char[] answers) {
    this.text = text;
    this.options = options;
    this.answers = answers;
  }
  /** 覆盖检查答案的方法, 实现多选题的具体检查用户答案逻辑 */
  public boolean check(char[] answers) {
    //answers 代表用户答案, this.answers 代表标准答案
    return Arrays.equals(answers, this.answers);
  }
}
