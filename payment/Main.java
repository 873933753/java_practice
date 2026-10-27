package payment;

class Payment {
  void pay(double amount){
    System.out.println("支付:" + amount);
  }
}

class CashPayment extends Payment {
  @Override 
  void pay(double amount){
    System.out.println("Cash支付:" + amount);
  }
}

class CardPayment extends Payment {
  @Override 
  void pay(double amount){
    System.out.println("Card支付:" + amount);
  }
}

class MobilePayment extends Payment {
  @Override 
  void pay(double amount){
    System.out.println("Mobile支付:" + amount);
  }
}

class Cashier {
  void checkout(Payment payment,double amount){
    payment.pay(amount);
  } 
}

// 新增支付方式，无需修改Cashier类
class CryptoPayment extends  Payment {
  @Override 
  void  pay(double amount){
    System.out.println("crypto支付：" + amount);
  }
}

public class Main {
  public static void main (String[] args) {
    Cashier cashier = new Cashier();
    
    Payment cashPayment = new CashPayment();
    Payment cardPayment = new CardPayment();
    Payment mobilePayment = new MobilePayment();
    // 新增支付方式，无需修改checkout方法
    Payment cryptoPayment = new CryptoPayment();
    
    cashier.checkout(cashPayment, 100.00);
    cashier.checkout(mobilePayment, 200.00);
    cashier.checkout(cardPayment, 300.00);
    cashier.checkout(cryptoPayment, 888.00);
  }
}