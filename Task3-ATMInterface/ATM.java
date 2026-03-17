

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User("samrat", "1234");
        Account account = new Account(10000);
        ATMOperations atm = new ATMOperations(account);

        System.out.println("===== ATM SYSTEM =====");

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (user.login(id, pin)) {

            System.out.println("Login Successful!");

            int choice = 0;

            while (choice != 5) {

                System.out.println("\n1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    atm.showHistory();
                } else if (choice == 2) {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    atm.withdraw(amt);
                } else if (choice == 3) {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    atm.deposit(amt);
                } else if (choice == 4) {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    atm.transfer(amt);
                } else if (choice == 5) {
                    System.out.println("Thank you!");
                } else {
                    System.out.println("Invalid choice!");
                }
            }

        } else {
            System.out.println("Invalid User ID or PIN");
        }

        sc.close();
    }
}