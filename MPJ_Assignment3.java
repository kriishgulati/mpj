import java.io.*;
import java.util.*;

// Custom Exceptions
class AmountException extends Exception {
    public AmountException(String msg) {
        super(msg);
    }
}

class BalanceException extends Exception {
    public BalanceException(String msg) {
        super(msg);
    }
}

class CustomerIdException extends Exception {
    public CustomerIdException(String msg) {
        super(msg);
    }
}

// Account Class
class Account {
    int id;
    String name;
    double balance;

    Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    void showDetails() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

// Main System Class
public class MPJ_Assignment3 {

    static Scanner input = new Scanner(System.in);
    static Account acc;

    // Create new account
    static void openAccount() throws Exception {

        System.out.print("Enter ID (1-20): ");
        int cid = input.nextInt();

        if (cid < 1 || cid > 20) {
            throw new CustomerIdException("Invalid ID range!");
        }

        System.out.print("Enter Name: ");
        String cname = input.next();

        System.out.print("Enter Initial Deposit: ");
        double bal = input.nextDouble();

        if (bal <= 0) {
            throw new AmountException("Amount should be greater than zero");
        }

        if (bal < 1000) {
            throw new AmountException("Minimum balance is 1000");
        }

        acc = new Account(cid, cname, bal);
        writeData();
        System.out.println("Account created successfully.");
    }

    // Deposit money
    static void addMoney() throws Exception {
        System.out.print("Enter deposit amount: ");
        double amt = input.nextDouble();

        if (amt <= 0) {
            throw new AmountException("Invalid deposit amount");
        }

        acc.balance = acc.balance + amt;
        writeData();
        System.out.println("Deposit successful.");
    }

    // Withdraw money
    static void removeMoney() throws Exception {
        System.out.print("Enter withdrawal amount: ");
        double amt = input.nextDouble();

        if (amt <= 0) {
            throw new AmountException("Invalid withdrawal amount");
        }

        if (amt > acc.balance) {
            throw new BalanceException("Not enough balance");
        }

        acc.balance -= amt;
        writeData();
        System.out.println("Withdrawal successful.");
    }

    // Write data to file
    static void writeData() {
        try {
            FileWriter writer = new FileWriter("cust_data.txt");
            writer.write(acc.id + "," + acc.name + "," + acc.balance);
            writer.close();
        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    // Read data from file
    static void readData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("cust_data.txt"));
            String line = reader.readLine();
            System.out.println("Stored Data: " + line);
            reader.close();
        } catch (IOException e) {
            System.out.println("File reading error");
        }
    }

    public static void main(String[] args) {

        int option;

        do {
            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Data");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            option = input.nextInt();

            try {
                switch (option) {
                    case 1:
                        openAccount();
                        break;
                    case 2:
                        addMoney();
                        break;
                    case 3:
                        removeMoney();
                        break;
                    case 4:
                        readData();
                        break;
                    case 5:
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Wrong choice!");
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

        } while (option != 5);
    }
}