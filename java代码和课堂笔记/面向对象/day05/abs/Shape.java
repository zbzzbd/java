package oop.day05.abs;

/** ��������, ���и���, ���ǲ������� 
 * �������Ϳ��Զ������
 * �������Ͳ���ʵ����(��������)
 * �������Ϳ���(ֻ��)���̳�
 * �������ͼ̳�һ����������, ����ʵ��ȫ���ĳ��󷽷�
 * */
public abstract class Shape {
  /** ͼ��������ϵ�е�λ�� */
  protected Point location;
  
  /** ����ͼ�ε����, ����ķ���, ֻ����Ϊ��, 
   * û�о���ļ������ */
  public abstract double area();
  /** �ж������Ƿ���ͼ������֮�� */
  public abstract boolean contains(int x, int y);
  /** �жϵ��Ƿ���ͼ������֮��, �Ǿ��巽�� */
  public boolean contains(Point p){
    return this.contains(p.x, p.y);
  }
}
