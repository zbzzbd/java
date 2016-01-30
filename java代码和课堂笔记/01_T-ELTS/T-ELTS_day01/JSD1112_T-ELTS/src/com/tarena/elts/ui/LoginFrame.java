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
  /** ��ʼ��, ��¼�����е�����Ͳ��� */
  private void init(){
    setTitle("��¼����ϵͳ");
    setSize(400, 300);
    setContentPane(createContentPane());
  }
  private JPanel createContentPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.NORTH, 
        new JLabel("��¼ϵͳ",JLabel.CENTER));
    p.add(BorderLayout.SOUTH, createBottomPane());
    return p;
  }
  private JPanel createBottomPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("��¼");
    JButton cancel = new JButton("ȡ��");
    p.add(login);
    p.add(cancel);
    return p;
  }
}










