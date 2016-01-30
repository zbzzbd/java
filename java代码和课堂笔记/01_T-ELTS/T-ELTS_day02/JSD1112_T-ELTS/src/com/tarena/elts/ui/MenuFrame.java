package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.elts.entity.User;

/** 主菜单界面 */
public class MenuFrame extends JFrame{
  
  public MenuFrame() {
    init();
  }
 
  private void init(){
    setTitle("达内科技在线测评");
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
        new JLabel("达内科技--版权所有 盗版必究",
            JLabel.RIGHT ));
       
    return pane;
  }
  private JPanel  createMenuPane(){
    JPanel pane = new JPanel(new BorderLayout());
    //务必将info 引用到界面控件对象
    JLabel info = 
      new JLabel("XXX 同学您好!", JLabel.CENTER);
    this.userInfo = info;
    pane.add(BorderLayout.NORTH, info);
    pane.add(BorderLayout.CENTER,createBtnPane());
       
    return pane;
  }
  private JPanel  createBtnPane(){
    JPanel pane = new JPanel(new FlowLayout());
    JButton start = createImgBtn("exam.png", "开始");
    JButton result = createImgBtn("result.png", "分数");
    JButton msg = createImgBtn("message.png", "考试规则");
    JButton exit = createImgBtn("exit.png", "离开");
 
    pane.add(start);
    pane.add(result);
    pane.add(msg);
    pane.add(exit);
    
    getRootPane().setDefaultButton(start);
 
    return pane;
  }
  // 创建图片按钮的方法
  private JButton createImgBtn(
      String img, String txt) {
    ImageIcon ico = new ImageIcon(
        this.getClass().getResource(img));
    
    JButton button = new JButton(txt, ico);
    //button.setIcon(ico);
    //垂直文本对齐位置
    button.setVerticalTextPosition(
        JButton.BOTTOM);
//  水平文本对齐位置
    button.setHorizontalTextPosition(
         JButton.CENTER);

    return button;
  }
  
  private JLabel userInfo;
  public void updateView(User loginUser) {
    userInfo.setText(
        "欢迎 "+ loginUser.getName() + " 童鞋!");
  }
   
}
