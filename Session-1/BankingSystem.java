import java.util.Scanner;

class BankAccount {
    // Attributes(Behaviour of the class)
    String accountHolder;
    int accountNumber;
    double balance;
    String accountType;

    public BankAccount(String accountHolder, int accountNumber, double balance, String accountType) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
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
    public double checkBalance(int amount) {
        this.balance = balance + amount; // This is not updating the balance, just returning it
        return balance;
    }

    // Print account details
    public void AccountHistory() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
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

        // System.out.print("Enter initial balance: ");
        // double initialBalance = scanner.nextDouble(); // Take Input as Double
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter account type (Savings/Current): ");
        String accountType = scanner.nextLine(); // Take Input as String

        // Create a new BankAccount object
        BankAccount account = new BankAccount(accountHolder, accountNumber, initialBalance, accountType);

        // Display Menu
        
        // TODO: Add case for this and make a PR on my branch with your name
        // TODO: Bydefault the initial balance should be 0.0
        // TODO: the balance should be updated balkance only after depositing or withdrawing money
        // TODO: if Arpit have a bank account number = 1234567890 then it has to be unique one.

        // If-Else Menu
        System.out.println("Choose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Account History");
        System.out.println("5. Exit");
        int choice = scanner.nextInt();
        if(choice == 1) {
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
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        // Close the scanner
        scanner.close();
        // End of the program
        System.out.println("Thank you for using the Banking System!");
        // End of the program
        System.out.println("Goodbye!");
    }
}
