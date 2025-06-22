import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    // Attributes(Behaviour of the class)
    String accountHolder;
    int accountNumber;
    double balance;
    String accountType;

    public BankAccount(String accountHolder, int accountNumber, double initialBalance, String accountType) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    // withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    // Print account details
    public void AccountHistory() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
    }

    // Map to store account numbers of users
    private static Map<String, List<Integer>> accountNumbers = new HashMap<>();

    // Check if account number is unique
    public static boolean isAccountNumberUnique(String accountHolder, int accountNumber) {
        if (accountNumbers.containsKey(accountHolder)) {
            if (accountNumbers.get(accountHolder).contains(accountNumber)) {
                return false;
            } else {
                accountNumbers.get(accountHolder).add(accountNumber);
                return true;
            }
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(accountNumber);
            accountNumbers.put(accountHolder, list);
            return true;
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Banking System!");

        // Create A new bank account
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine(); // Take Input as String
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt(); // Take Input as Integer
        scanner.nextLine(); // Consume the newline character

        // Check if account number is unique
        if (BankAccount.isAccountNumberUnique(accountHolder, accountNumber)) {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble(); // Take Input as Double
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter account type (Savings/Current): ");
            String accountType = scanner.nextLine(); // Take Input as String

            // Create a new BankAccount object
            BankAccount account = new BankAccount(accountHolder, accountNumber, initialBalance, accountType);

            // Display Menu
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Account History");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                } else if (choice == 2) {
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                } else if (choice == 3) {
                    System.out.println("Current Balance: " + account.checkBalance());
                } else if (choice == 4) {
                    account.AccountHistory();
                } else if (choice == 5) {
                    System.out.println("Exiting the Banking System. Thank you!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Account number already exists. Please try again.");
        }

        // Close the scanner
        scanner.close();

        // End of the program
        System.out.println("Thank you for using the Banking System!");
        // End of the program
        System.out.println("Goodbye!");
    }
}
