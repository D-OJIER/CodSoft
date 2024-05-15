package task_3;

import java.util.Scanner;

class Account {
    private double bal;

    public Account(double initBal) {
        bal = initBal;
    }

    public double getBal() {
        return bal;
    }

    public void deposit(double amt) {
        bal += amt;
    }

    public boolean withdraw(double amt) {
        if (bal >= amt) {
            bal -= amt;
            return true;
        }
        return false;
    }
}

class ATM {
    private Account acct;
    private Scanner sc;

    ATM(Account acct) {
        this.acct = acct;
        sc = new Scanner(System.in);
    }

    void displayMenu() {
        System.out.println("Choose the option!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    void processOption(int opt) {
        switch (opt) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBal();
                break;
            case 4:
                System.out.println("Thank you!");
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount you want to withdraw: ");
        double amt = sc.nextDouble();
        if (amt <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (acct.withdraw(amt)) {
            System.out.println("Withdrawal successful. Remaining balance: " + acct.getBal());
        } else {
            System.out.println("Low balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount you want to deposit: ");
        double amt = sc.nextDouble();
        if (amt <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        acct.deposit(amt);
        System.out.println("Deposit successful. New balance: " + acct.getBal());
    }

    private void checkBal() {
        System.out.println("Your current balance is: " + acct.getBal());
    }
}

public class Main {
    public static void main(String[] args) {
        Account acct = new Account(15000);
        ATM atm = new ATM(acct);
        char cont;
        do {
            atm.displayMenu();
            System.out.print("Please select the option: ");
            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
            atm.processOption(opt);
            System.out.println("Do you want to continue? (y/n)");
            cont = sc.next().charAt(0);
        } while (cont == 'y');
    }
}

