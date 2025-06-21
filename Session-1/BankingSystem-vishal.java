import java.util.*;

class BankAccount {
    int accountNumber;
    String accountHolderName;
    String accountType;
    public double balance;

    public BankAccount(String accountHolderName, int accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("New Balance:" + this.balance);
        }
    }

    // Withdraw
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            this.balance = this.balance - withdrawAmount;
            System.out.println("New amount after withdraw:" + this.balance);
        } else {
            System.out.println("Insufficient amount");
        }
    }

    // check balance
    public void checkBalance() {
        System.out.println("Updated balance:" + this.balance);
    }

    // check if account number already exists
    public boolean checkAccountNumber(int num) {
        ArrayList<Integer> accountNum = new ArrayList<>();
        {
            // These are the account numbers that already exists in the system.
            accountNum.add(12345);
            accountNum.add(67890);
            accountNum.add(1234567890);

        }
        if (accountNum.contains(num)) {
            System.out.println("Account Number already exists!!");
            System.out.println("Enter new account number");
            return true;
        } else {
            this.accountNumber = num;
            return false;
        }

    }

    // Print account details
    public void AccountHistory() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
        System.out.println("Account Type: " + accountType);
    }

    public void exitProgram() {
        System.exit(0);
    }
}

class Banking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System!");

        // Create A new bank account
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine(); // Take Input as String
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter account type (Savings/Current): ");
        String accountType = scanner.nextLine(); // Take Input as String

        // Create a new BankAccount object
        BankAccount account = new BankAccount(accountHolderName, number, accountType);

        // Display Menu

        // TODO: Add case for this and make a PR on my branch with your name
        // TODO: Bydefault the initial balance should be 0.0
        // TODO: the balance should be updated balkance only after depositing or
        // withdrawing money
        // TODO: if Arpit have a bank account number = 1234567890 then it has to be
        // unique one.

        // switch case Menu

        while (true) {
            if (account.checkAccountNumber(number) == true)
                number = scanner.nextInt();
            else {
                System.out.println("Choose an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Account History");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Current Balance: ");
                        account.checkBalance();
                        break;
                    case 4:
                        account.AccountHistory();
                        break;
                    case 5:
                        System.out.println("Exiting the Banking System. Thank you!");
                        // Close the scanner
                        scanner.close();
                        // End of the program
                        System.out.println("Thank you for using the Banking System!");
                        // End of the program
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        // this is vishal kumar. TODO tasks are now completed.
    }
}