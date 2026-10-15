// InsufficientFundsException.java
public class InsufficientFundsException extends Exception {   // checked
    private final double balance;
    private final double requested;

    public InsufficientFundsException(double balance, double requested) {
        super(String.format("Insufficient funds: balance is %.2f but %.2f was requested (short by %.2f).",
                balance, requested, requested - balance));
        this.balance = balance;
        this.requested = requested;
    }

    public double getBalance()   { return balance; }
    public double getRequested() { return requested; }
    public double getShortfall() { return requested - balance; }
}

// BankAccount.java
class BankAccount2 {

    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount2(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // CHANGED: returns void and throws instead of returning boolean
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);   // state unchanged
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}

// BankDemo.java
class BankDemo {
    public static void main(String[] args) {
        BankAccount2 acc = new BankAccount2("ACC-001", "Tendai", 500.00);

        acc.deposit(250.00);
        System.out.println(acc);

        try {
            acc.withdraw(100.00);
            System.out.println("Withdraw 100: success");

            acc.withdraw(5000.00);                       // throws here
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e) {
            System.out.println("Withdraw failed: " + e.getMessage());
            System.out.println("Shortfall: " + e.getShortfall());
        }

        System.out.println(acc);

        try {
            acc.deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}