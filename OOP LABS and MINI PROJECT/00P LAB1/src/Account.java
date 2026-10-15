
    // Account.java
    public abstract class Account {
        private final String accountNumber;
        protected double balance;

        public Account(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        // Concrete method: shared by all account types
        public void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit must be positive.");
            }
            balance += amount;
        }

        // Abstract method: each account type defines its own fee
        public abstract double monthlyFee();

        // Applies the fee to the balance
        public void applyMonthlyFee() {
            balance -= monthlyFee();
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + accountNumber
                    + " [balance=" + String.format("%.2f", balance)
                    + ", monthlyFee=" + String.format("%.2f", monthlyFee()) + "]";
        }
    }

    // SavingsAccount.java
    class SavingsAccount extends Account {
        private static final double FEE = 2.50;

        public SavingsAccount(String accountNumber, double initialBalance) {
            super(accountNumber, initialBalance);
        }

        @Override
        public double monthlyFee() {
            return FEE;
        }
    }

    // CurrentAccount.java
    class CurrentAccount extends Account {
        private static final double BASE_FEE = 10.00;
        private static final double FEE_WAIVER_BALANCE = 1000.00;

        public CurrentAccount(String accountNumber, double initialBalance) {
            super(accountNumber, initialBalance);
        }

        // Fee is waived if the balance is high enough
        @Override
        public double monthlyFee() {
            return balance >= FEE_WAIVER_BALANCE ? 0.0 : BASE_FEE;
        }
    }

    // Main.java
     class AccountDemo{
        public static void main(String[] args) {
            Account[] accounts = {
                    new SavingsAccount("SAV-001", 500),
                    new CurrentAccount("CUR-001", 800),
                    new CurrentAccount("CUR-002", 2000)
            };

            for (Account a : accounts) {
                a.deposit(100);
                System.out.println("Before fee: " + a);
                a.applyMonthlyFee();
                System.out.println("After fee:  " + a);
                System.out.println();
            }
        }
    }

