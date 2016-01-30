package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
 

public class ExamFrame extends JFrame{
 
  private static final long serialVersionUID = 
    -5355432125621015300L;
  
  //ѡ���, ����𰸶�ȡ�Ĵ���
  private Option[] options = new Option[4];
  public ExamFrame() {
    init();
  }
  private void init(){
    setTitle("���ڿƼ����߲���");
    setSize(600,380);
    setContentPane(createContentPane());
  }
  private JPanel createContentPane(){
    JPanel pane = new JPanel(new BorderLayout());
    pane.setBorder(new EmptyBorder(6,6,6,6));
    ImageIcon icon = new ImageIcon(
        getClass().getResource("exam_title.png"));            
    
    pane.add(BorderLayout.NORTH, 
        new JLabel(icon));
    
    pane.add(BorderLayout.CENTER,
        createCenterPane());
    
    pane.add(BorderLayout.SOUTH, 
        createToolsPane());
       
    return pane;
  }
  private JPanel createCenterPane() {
    JPanel pane = new JPanel(new BorderLayout());
//  ע��!
    JLabel examInfo = 
      new JLabel("����:XXX ����:XXX ����ʱ��:XXX", 
          JLabel.CENTER);
 
    pane.add(BorderLayout.NORTH, examInfo);
    
    pane.add(BorderLayout.CENTER, 
        createQuestionPane());
    pane.add(BorderLayout.SOUTH, 
        createOptionsPane());
    return pane;
  }
  private JPanel createOptionsPane(){
    JPanel pane = new JPanel();
    Option a = new Option(0,"A");
    Option b = new Option(1,"B");
    Option c = new Option(2,"C");
    Option d = new Option(3,"D");
    options[0]=a;
    options[1]=b;
    options[2]=c;
    options[3]=d;
    pane.add(a);
    pane.add(b);
    pane.add(c);
    pane.add(d);
    return pane;
  }
  private JScrollPane createQuestionPane() {
    JScrollPane pane = new JScrollPane();
    pane.setBorder(new TitledBorder("��Ŀ"));//�����
    
    //ע��!
    JTextArea questionArea = new JTextArea();
    
    questionArea.setText("����\nA.\nB.");
    questionArea.setLineWrap(true);//����������ʾ
    questionArea.setEditable(false);//���ܹ��༭����
    //JTextArea ����ŵ� JScrollPane ����ͼ������(Viewport)
    pane.getViewport().add(questionArea);
    return pane;
  }
  private JPanel createToolsPane() {
    JPanel pane = new JPanel(new BorderLayout());
    pane.setBorder(new EmptyBorder(0,10,0,10));
//  ע��!
    JLabel questionCount =
      new JLabel("��Ŀ:20 �� 1��");
    
    JLabel timer =
      new JLabel("ʣ��ʱ��:222��");
 
    pane.add(BorderLayout.WEST, questionCount );
    pane.add(BorderLayout.EAST, timer );
    pane.add(BorderLayout.CENTER, createBtnPane());
    return pane;
  }
  private JPanel createBtnPane() {
    JPanel pane = new JPanel(new FlowLayout());
    JButton prev = new JButton("��һ��");
    JButton next = new JButton("��һ��");
    JButton send = new JButton("����");
 
    pane.add(prev);
    pane.add(next);
    pane.add(send);
    
    return pane;
  }
  /** ʹ���ڲ�����չ�� JCheckBox ������val ����, �����ֵ*/
  class Option extends JCheckBox{
    private static final long serialVersionUID = 5569918347028393191L;
    int value;
    public Option(int val, String txt) {
      super(txt);
      this.value = val;
    }
  }
   
}












