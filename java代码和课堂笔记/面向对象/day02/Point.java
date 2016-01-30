package oop.day02;
/** ������ */
public class Point {
  int x;
  int y;
  /** ������������һ��(�涨!)
   * ������������ֵ����(�涨!)
   * �����в���, �����ǹ�������ǰ������
   * ��������������(Overload)
   * ��������ĳ�ʼ������, �ڷ��������Կռ��Ժ����
   *  */
  public Point(/* Point this, */int x, int y){
    //this.����"��ǰ"����, �ǵ�ǰ���������
    System.out.println(this.x);//0
    System.out.println(x);//3,1
    this.x = x;
    this.y = y;
  }
  /** �����Խ����ϵĵ�, ���صĹ�����, Ϊ�˷������ʹ�� */
  public Point(int x){
    //this() ���õ�ǰ�����������
    //this() ֻ�����ڹ�������, ֻ��д�ڹ������ĵ�һ��(�涨)
    //System.out.println(this.x); //����������
    this(x,x);//������������(�ظ�����), ���Լ��ٱ�����
//    this.x = x;
//    this.y = x;
    //JTable
  }
  /** ���㵱ǰ��(this(x,y))��ԭ��(0,0)�ľ��� */
  public double distance(){
    return Math.sqrt(this.x*this.x + this.y*this.y);
  }
  /** ����������(Overload): ������һ��, ���������б�һ��) */
  /** ���㵱ǰ��(this)��һ������(x,y)�ľ��� */
  public double distance(int x, int y){
    //this���������ڼ�ȷ��, �����õ����÷����Ķ���
    //�з����Ķ�̬��(�����ڼ�ȷ��)!
    return Math.sqrt((this.x-x)*(this.x-x) + 
        (this.y-y)*(this.y-y));
  }
  /** ��ǰ��(this)������һ��(other)�ľ��� */
  public double distance(Point other){
    //���������໥����
    return this.distance(other.x, other.y);
  }
}








