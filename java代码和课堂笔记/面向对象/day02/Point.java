package oop.day02;
/** 点类型 */
public class Point {
  int x;
  int y;
  /** 方法名与类名一致(规定!)
   * 不能声明返回值类型(规定!)
   * 可以有参数, 参数是构造器的前提条件
   * 构造器可以重载(Overload)
   * 描述对象的初始化过程, 在分配完属性空间以后调用
   *  */
  public Point(/* Point this, */int x, int y){
    //this.代表"当前"对象, 是当前对象的引用
    System.out.println(this.x);//0
    System.out.println(x);//3,1
    this.x = x;
    this.y = y;
  }
  /** 创建对角线上的点, 重载的构造器, 为了方便类的使用 */
  public Point(int x){
    //this() 调用当前类的其他构造
    //this() 只能用于构造器中, 只能写在构造器的第一行(规定)
    //System.out.println(this.x); //引起编译错误
    this(x,x);//构造器的重用(重复利用), 可以减少编码量
//    this.x = x;
//    this.y = x;
    //JTable
  }
  /** 计算当前点(this(x,y))到原点(0,0)的距离 */
  public double distance(){
    return Math.sqrt(this.x*this.x + this.y*this.y);
  }
  /** 方法的重载(Overload): 方法名一样, 参数类型列表不一样) */
  /** 计算当前点(this)到一个坐标(x,y)的距离 */
  public double distance(int x, int y){
    //this是在运行期间确定, 是引用到调用方法的对象
    //叫方法的动态绑定(运行期间确定)!
    return Math.sqrt((this.x-x)*(this.x-x) + 
        (this.y-y)*(this.y-y));
  }
  /** 当前点(this)到另外一点(other)的距离 */
  public double distance(Point other){
    //方法可以相互重用
    return this.distance(other.x, other.y);
  }
}








