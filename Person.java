import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person{
  private String id;
  private String name;
  private int age;

  public Person(String id, String name, int age) {
    this.name = name;
    this.id = id;
    this.age = age;
  }

  /* 重写toString */
  @Override
  public String toString(){
    return "Person{id = " + id + ", name = " + name + ", age = " + age + "}";
  }

  /* 重写equals */
  // 重写了equals必须重写hashCode，因为如果 a.equals(b) 为 true，则 a.hashCode() 必须等于 b.hashCode()。
  @Override  
  public boolean equals(Object o){
    if (this == o) return  true; // 1) 自反性检查   自己和自己比，肯定相等
    if (o == null || getClass() != o.getClass()) return  false; // 2) 空值与类型检查

    Person person = (Person) o; // 3)
    return  Objects.equals(id, person.id) && Objects.equals(name, person.name) && age == person.age; // 字符串要用引用类型的比较
  }

  @Override 
  public int hashCode(){
    return  Objects.hash(id,name,age);
  }

  public static void main(String[] args){
    Person xiaoming = new Person("123","xiaoming",18);
    System.out.println(xiaoming); // Person{id = 123, name = xiaoming, age = 18} 否则 Person@18b4aac2

    Person user1 = new Person("1","user",18);
    Person user2 = new Person("1","user",18);
    System.out.println(user1 == user2); // false -- == 在引用类型中比的是地址
    System.out.println(user1.equals(user2)); // false equals默认比的是地址，重写equals比内容 true


    Set<Person> set = new HashSet<>();
    set.add(user1);
    set.add(user2);

    System.out.println(set.size()); // HashSet 添加两个内容相同的对象，因为 equals 和 hashCode 都重写了，所以只保留一个，size() 是 1
  }
}

/* public class Main{
  public static void main(String[] args){
    Person xiaoming = new Person("123","xiaoming",18);
    System.out.println(xiaoming); // Person{id = 123, name = xiaoming, age = 18} 否则 Person@18b4aac2

    Person user1 = new Person("1","user",18);
    Person user2 = new Person("1","user",18);
    System.out.println(user1 == user2); // false -- == 在引用类型中比的是地址
    System.out.println(user1.equals(user2)); // false equals默认比的是地址，重写equals比内容 true
  }
} */