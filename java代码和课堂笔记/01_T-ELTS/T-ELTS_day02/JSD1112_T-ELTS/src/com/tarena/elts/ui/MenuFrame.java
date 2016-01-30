package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

/** ���˵����� */
public class MenuFrame extends JFrame{
  
  public MenuFrame() {
    init();
  }
 
  private void init(){
    setTitle("���ڿƼ����߲���");
    setSize(600,400);
    setContentPane(createContentPane());
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
  }

  private JPanel createContentPane(){
    JPanel pane = new JPanel(new BorderLayout());
    
    ImageIcon icon = new ImageIcon(
        this.getClass().getResource("title.png"));    
    
    //MenuFrame.class.getResource("title.png");
    
    pane.add(BorderLayout.NORTH,new JLabel(icon));
    
    pane.add(BorderLayout.CENTER,createMenuPane());
    
    pane.add(BorderLayout.SOUTH, 
        new JLabel("���ڿƼ�--��Ȩ���� ����ؾ�",
            JLabel.RIGHT ));
       
    return pane;
  }
  private JPanel  createMenuPane(){
    JPanel pane = new JPanel(new BorderLayout());
    //��ؽ�info ���õ�����ؼ�����
    JLabel info = 
      new JLabel("XXX ͬѧ����!", JLabel.CENTER);
    this.userInfo = info;
    pane.add(BorderLayout.NORTH, info);
    pane.add(BorderLayout.CENTER,createBtnPane());
       
    return pane;
  }
  private JPanel  createBtnPane(){
    JPanel pane = new JPanel(new FlowLayout());
    JButton start = createImgBtn("exam.png", "��ʼ");
    JButton result = createImgBtn("result.png", "����");
    JButton msg = createImgBtn("message.png", "���Թ���");
    JButton exit = createImgBtn("exit.png", "�뿪");
 
    pane.add(start);
    pane.add(result);
    pane.add(msg);
    pane.add(exit);
    
    getRootPane().setDefaultButton(start);
 
    return pane;
  }
  // ����ͼƬ��ť�ķ���
  private JButton createImgBtn(
      String img, String txt) {
    ImageIcon ico = new ImageIcon(
        this.getClass().getResource(img));
    
    JButton button = new JButton(txt, ico);
    //button.setIcon(ico);
    //��ֱ�ı�����λ��
    button.setVerticalTextPosition(
        JButton.BOTTOM);
//  ˮƽ�ı�����λ��
    button.setHorizontalTextPosition(
         JButton.CENTER);

    return button;
  }
  
  private JLabel userInfo;
  public void updateView(User loginUser) {
    userInfo.setText(
        "��ӭ "+ loginUser.getName() + " ͯЬ!");
  }
   
}
