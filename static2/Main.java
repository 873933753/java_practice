package static2;

abstract class Employee {
  String id;
  String name;

  // 抽象方法 - 每种员工的薪资计算方式不同
  public abstract double calculateSalary();

  // 普通方法 - 所有员工共享
  public String getInfo(){
    return "编号："+id+",姓名："+name+",月薪："+calculateSalary();
  }

  // 构造
  public Employee(String id,String name){
    this.id = id;
    this.name = name;
  }

}

class FullTimeEmployee extends Employee {

  private int days;
  private double daySalary;

  // 子类通过super调用父类的构造函数
  public FullTimeEmployee(String id,String name,int days,double daySalary){
    super(id,name);
    this.days = days;
    this.daySalary = daySalary;
  }

  @Override 
  public double calculateSalary(){
    return days * daySalary;
  }
}

class PartTimeEmployee extends Employee {
  private int days;
  private double daySalary;

  public PartTimeEmployee(String id,String name,int days,double daySalary){
    super(id,name);
    this.days = days;
    this.daySalary = daySalary;
  }

  @Override 
  public double calculateSalary(){
    return days * daySalary;
  }
}

public class Main {
  public static void main (String[] args) {
    Employee fullTime = new FullTimeEmployee("001", "张三", 10, 100.00);
    System.out.println(fullTime.getInfo()); // 编号：001,姓名：张三,月薪：1000.0
  }  
}
