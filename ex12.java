import java.util.Scanner;

class ATM {
    int accountNo = 101;
    int pin = 1234;
    double balance = 5000;

    void checkBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

public class ATMManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM a = new ATM();

        System.out.print("Enter PIN: ");
        int p = sc.nextInt();

        if (p == a.pin) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    a.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    a.deposit(sc.nextDouble());
                    a.checkBalance();
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    a.withdraw(sc.nextDouble());
                    a.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }
}