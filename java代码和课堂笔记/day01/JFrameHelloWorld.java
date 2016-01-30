package basic.day01;

import javax.swing.JFrame;//窗口框
import javax.swing.JLabel;//用来显示文本标签
import javax.swing.JPanel;//面板, 可以嵌在窗口中

/** 图形用户界面版本的演示 */
public class JFrameHelloWorld {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JFrame演示");//窗口框
    JPanel pane = new JPanel();//面板
    JLabel label = new JLabel("Hello Worls");//文字标签
    pane.add(label); //面板添加标签
    frame.setContentPane(pane);//窗口框设置内容面板是 pane
    frame.setSize(300, 200);//设置大小
    frame.setVisible(true);//窗口框设置可见性为真的
  }
} //以后专门安排课程讲解JDK的配置与使用


