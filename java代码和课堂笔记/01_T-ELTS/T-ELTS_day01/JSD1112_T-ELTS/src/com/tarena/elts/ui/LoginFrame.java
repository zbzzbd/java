package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginFrame extends JFrame {
  public LoginFrame() {
    init();
  }
  /** 初始化, 登录窗口中的组件和布局 */
  private void init(){
    setTitle("登录考试系统");
    setSize(400, 300);
    setContentPane(createContentPane());
  }
  private JPanel createContentPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.NORTH, 
        new JLabel("登录系统",JLabel.CENTER));
    p.add(BorderLayout.SOUTH, createBottomPane());
    return p;
  }
  private JPanel createBottomPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("登录");
    JButton cancel = new JButton("取消");
    p.add(login);
    p.add(cancel);
    return p;
  }
}










