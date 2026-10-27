class Shape {
  void draw(){
    System.out.println("画一个图形");
  }
}

class Square extends Shape {
  @Override 
  void draw(){
    System.out.println("画方");
  }
}

class Circle extends Shape {
  /*方法重写 */
  @Override 
  void  draw(){
    System.out.println("画圆");
  }
}

// 多态 -- 一个类可以有多重形态
/* 多态的优点：
1）消除类型判断
当没有多态时,处理不同动物要靠可怕的类型判断,我们称之为"判断地狱":

*/

public class Main {
    public static void main(String[] args) {
        /* 多态的实现需要三个条件,缺一不可:继承关系、方法重写、向上转型。  */
        Shape s1 = new Circle();   // 父类型变量，装子类对象 --- 向上转型
        Shape s2 = new Square();   // 左边 Shape 是变量的声明类型（编译期看的），右边 new Circle() 是对象的实际类型（运行期看的）。父类型决定“你能调用什么”，子类型决定“实际跑什么”。
        Shape s3 = new Shape();

        s1.draw();   // 输出：画圆   
        s2.draw();   // 输出：画方
        s3.draw(); // 输出：画一个图形
    }
}