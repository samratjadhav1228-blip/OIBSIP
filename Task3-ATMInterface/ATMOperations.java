

public class ATMOperations {

    private Account account;
    private Transaction transaction;

    public ATMOperations(Account account) {
        this.account = account;
        this.transaction = new Transaction();
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transaction.add("Deposited: " + amount);
        System.out.println("Deposit Successful!");
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            transaction.add("Withdrawn: " + amount);
            System.out.println("Withdraw Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(double amount) {
        if (account.withdraw(amount)) {
            transaction.add("Transferred: " + amount);
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showHistory() {
        transaction.show();
    }
}