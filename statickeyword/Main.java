package statickeyword;

class CoffeeShop {
  // 实例变量，每个对象都不一样
  int id;
  String address;

  // 静态变量（属于类，所有实例共享）
  static String openingHours = "8:00-22:00"; // 因为每个店的营业时间一样

  public CoffeeShop(int id,String address){
    this.id = id;
    this.address = address;
  }

  // 静态方法 - 
  public static void changeHours(String newHours){
    CoffeeShop.openingHours = newHours; // 访问静态变量,用类名.静态变量
  }
}

public class Main {
  public static void main (String[] args){
    // 每个对象有自己的数据
    CoffeeShop shop1 = new CoffeeShop(0, "xx路xx号");
    CoffeeShop shop2 = new CoffeeShop(0, "xx路xx号");

    shop1.id = 123; // 实例变量在实例对象上修改
    System.out.println(shop1.id); // 123

    CoffeeShop.openingHours = "9:00 - 17:00"; // 在类上修改静态变量
    System.out.println(CoffeeShop.openingHours); // "9:00 - 17:00"

    CoffeeShop.changeHours("9:10-17:10"); // 调用类上的静态方法
    System.out.println(CoffeeShop.openingHours); // 9:10-17:10

  }
}
