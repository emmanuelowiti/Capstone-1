package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MainApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TransactionManager.transactions("transactions.csv");

        boolean isRunning = false; //keep the program running if set to true

        while (!isRunning) {
            isRunning = homeScreen();
        }

    }

    public static boolean homeScreen() {
        // TransactionManager.transactions("transactions.csv");
        String options = """
                =========================
                    Home Menu
                =========================
                1) Add Deposit
                2) Make Payment
                3) Go to Ledger
                4) Exit 🏁
                """;
        System.out.println(options);
        System.out.print("Enter a number to choose an option: \n");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            //one for deposit, ledger, make payment, invalid choice, exit
            case 1:
                addDeposit();
                break;
            case 2:
                addPayment();
                break;
            case 3:
                ledgerScreen();
                break;
            case 4:
                System.out.println("Exit the program");
                return true;
            default:
                System.out.println("Invalid choice! Try again\n");
                break;
        }
        return false;
    }

    //method to deposit
    public static void addDeposit() {
        //get the amount
        System.out.println("💰Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        //get the vendor
        System.out.println("Enter the vendor information:");
        String vendor = scanner.nextLine();
        //get description
        System.out.println("Add description to the deposit:");
        String description = scanner.nextLine();

        // create Transaction Object
        Ledger.makeDeposit(amount, vendor, description);


    }

    public static void addPayment() {
        //get the amount
        System.out.println("💰Enter amount to make payment:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        //get the vendor
        System.out.println("Enter the vendor information:");
        String vendor = scanner.nextLine();
        //get description
        System.out.println("Add description to the payment:");
        String description = scanner.nextLine();

        Ledger.addPayment(amount, vendor, description);
    }

    public static void ledgerScreen() {
        String options = """
                =========================
                    Ledger Screen
                =========================
                1) Show all transactions
                2) Show Deposits
                3) Show Payments
                4) Show Reports
                5)Go to Homepage
                """;
        System.out.println(options);
        System.out.println("Enter a number to choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Ledger.showAllTransactions();
                break;//show all transactions
            case 2:
                Ledger.showAllDeposits();
                break;//show all deposits
            case 3:
                Ledger.showAllPayments();
                break;//show all payments(negative)
            case 4:
                showReports();
                break;//Show reports
            case 5://Got to homepage
                homeScreen();
                break;
            default://Handle any outside inputs
                System.out.println("⚠️Invalid choice! Try again\n");
                break;
        }

    }

    public static void showReports() {
        String options = """
                =========================
                    Reports Screen
                =========================
                1) Month To Date
                2) Previous Month
                3) Year To Date
                4) Previous Year
                5) Search by Vendor
                """;
        System.out.println(options);
        System.out.println("Enter a number to choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                previousYear();
                break;
            case 5:
               /* System.out.println("What name do you want to search for?");
                String nameToSearchFor = scanner.nextLine();
                List<Transaction> matchesByName = Transaction.getVendor(TransactionManager, nameToSearchFor);
                Ledger.ledger.getVendor(matchesByName);*/
                break;
               // findVendor();

            default:
                System.out.println("⚠️Invalid choice! Try again\n");
                break;
        }
    }


    public static void previousYear() {
        var transactions = TransactionManager.transactions("transactions.csv");
        LocalDate now = LocalDate.now();
        int lastYear = now.getYear() - 1;
        System.out.println("\nTransactions for last year:");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == lastYear) {
                System.out.println(transaction);

            }
        }

    }
}


