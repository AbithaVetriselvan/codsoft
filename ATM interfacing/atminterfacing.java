import java.util.Scanner;


// Class to represent the user's bank account
class BankAccount {
 
   private double balance;

    public BankAccount(double initialBalance)
 {
 
       balance = initialBalance;

    }


    public double getBalance() {
        return balance;
 
   }

 
   public void deposit(double amount) {
        balance += amount;

    }

 
   public boolean withdraw(double amount) {
 
       if (balance >= amount) {
        
    balance -= amount;
        
    return true;
 
       }

        return false;

    }

}


// Class to represent the ATM machine
class ATM {
 
   private BankAccount account;

 
   public ATM(BankAccount account) {
 
       this.account = account;
 
   }


    public void displayMenu() {

        System.out.println("ATM Menu:");
 
        System.out.println("1. Check Balance");
 
        System.out.println("2. Deposit");
  
        System.out.println("3. Withdraw");
 
        System.out.println("4. Exit");
 
   }


    public void run() {
 
       Scanner scanner = new Scanner(System.in);


        while (true) {

            displayMenu();
 
           System.out.print("Select an option: ");

            int choice = scanner.nextInt();


            switch (choice) {
 
               case 1:
 
                   System.out.println("Current Balance: $" + account.getBalance());

                    break;

                case 2:
 
                   System.out.print("Enter deposit amount: $");

                    double depositAmount = scanner.nextDouble();
 
                   account.deposit(depositAmount);
 
                   System.out.println("Deposit successful.");

                    break;
 
               case 3:

                    System.out.print("Enter withdrawal amount: $");

                    double withdrawalAmount = scanner.nextDouble();
 
                   if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful.");

                    } else {
 
                       System.out.println("Insufficient balance.");
 
                   }
  
                  break;

                case 4:
 
                   System.out.println("Exiting ATM. Thank you!");

                    scanner.close();
 
                   System.exit(0);
 
                   break;

                default:
 
                   System.out.println("Invalid option. Please try again.");
 
                   break;

            }
 
       }

    }

}


public class Main {
 
   public static void main(String[] args) {
 
       BankAccount userAccount = new BankAccount(1000.0); // Initial balance
  
      ATM atm = new ATM(userAccount);

        atm.run();
 
   }

}