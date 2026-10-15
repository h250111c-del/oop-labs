abstract class Payment {
    protected double amount;
    Payment(double amount){this.amount = amount;}
    abstract void process();                         //each payment type supplies its own behaviour

}

class CardPayment extends Payment{
    public CardPayment(){
        super(0);
    }
    @Override
    public void process(){
        System.out.println("Card processed");
    }
}
 class MobileMoneyPayment extends Payment{
    public MobileMoneyPayment (){
        super(0);
    }
    @Override
    public  void process(){
        System.out.println("Mobile money processed");
    }
}
class PaymentProcessor{
    static void pay(Payment p){
        p.process();
    }
}
class PaymentDemo{
    public static void main(String[] args){
        Payment p1= new CardPayment();
        Payment p2 = new MobileMoneyPayment();

        PaymentProcessor.pay(p1);
        PaymentProcessor.pay(p2);
    }

}

