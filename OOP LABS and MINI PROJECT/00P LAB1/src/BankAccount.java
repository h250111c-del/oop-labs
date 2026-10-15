import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BankAccount {
    private double balance;
    private List<String> history = new ArrayList<>(); //private so no outside access

    public void deposit(double amount){
        balance += amount;
        history.add("Deposited " + amount);  //record each transaction
    }
    //Unmodified COPY:callers can read it but cannot change it
    public List<String>  getHistory(){
        return Collections.unmodifiableList(new ArrayList<>(history));
    }
    public static void main(String[] args){
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        System.out.println(acc.getHistory());  //Deposited 500
        try{
            acc.getHistory().add("Hacked");  //blocked
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified");

        }
    }
}
