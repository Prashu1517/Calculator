import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int inputPin;

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        inputPin = scanner.nextInt();

        if (inputPin == pin) {
            System.out.println("PIN is correct. Logging in...");
            login(scanner);
        } else {
            System.out.println("Invalid PIN. Please try again.");
        }
    }

    private void login(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private void withdrawCash(Scanner scanner) {
        double amount;

        System.out.print("Enter the amount to withdraw: $");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        }
    }

    private void depositCash(Scanner scanner) {
        double amount;

        System.out.print("Enter the amount to deposit: $");
        amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1000.0);
        atm.start();
    }
}