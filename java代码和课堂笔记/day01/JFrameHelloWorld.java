package basic.day01;

import javax.swing.JFrame;//���ڿ�
import javax.swing.JLabel;//������ʾ�ı���ǩ
import javax.swing.JPanel;//���, ����Ƕ�ڴ�����

/** ͼ���û�����汾����ʾ */
public class JFrameHelloWorld {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JFrame��ʾ");//���ڿ�
    JPanel pane = new JPanel();//���
    JLabel label = new JLabel("Hello Worls");//���ֱ�ǩ
    pane.add(label); //�����ӱ�ǩ
    frame.setContentPane(pane);//���ڿ�������������� pane
    frame.setSize(300, 200);//���ô�С
    frame.setVisible(true);//���ڿ����ÿɼ���Ϊ���
  }
} //�Ժ�ר�Ű��ſγ̽���JDK��������ʹ��


