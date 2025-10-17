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

        boolean isRunning = false;

        while (!isRunning) {
            isRunning = homeScreen();
        }
    }

    public static boolean homeScreen() {
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

    public static void addDeposit() {
        System.out.println("💰Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the vendor information:");
        String vendor = scanner.nextLine();

        System.out.println("Add description to the deposit:");
        String description = scanner.nextLine();

        Ledger.makeDeposit(amount, vendor, description);
    }

    public static void addPayment() {
        System.out.println("💰Enter amount to make payment:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the vendor information:");
        String vendor = scanner.nextLine();

        System.out.println("Add description to the payment:");
        String description = scanner.nextLine();

        Ledger.addPayment(amount, vendor, description);
    }

    public static void ledgerScreen() {
        boolean stayInLedger = true;

        while (stayInLedger) {
            String options = """
                    =========================
                        Ledger Screen
                    =========================
                    1) Show all transactions
                    2) Show Deposits
                    3) Show Payments
                    4) Show Reports
                    5) Go to Homepage
                    """;
            System.out.println(options);
            System.out.println("Enter a number to choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Ledger.showAllTransactions();
                    break;
                case 2:
                    Ledger.showAllDeposits();
                    break;
                case 3:
                    Ledger.showAllPayments();
                    break;
                case 4:
                    showReports();
                    break;
                case 5:
                    stayInLedger = false;
                    break;
                default:
                    System.out.println("⚠️Invalid choice! Try again\n");
                    break;
            }
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
                0) Back
                """;
        System.out.println(options);
        System.out.println("Enter a number to choose an option:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                monthToDate();
                break;
            case 2:
                previousMonth();
                break;
            case 3:
                yearToDate();
                break;
            case 4:
                previousYear();
                break;
            case 5:
                searchByVendor();
                break;
            case 0:
                ledgerScreen();
                break;
            default:
                System.out.println("⚠️Invalid choice! Try again\n");
                break;
        }
    }

    public static void monthToDate() {
        LocalDate now = LocalDate.now();
        LocalDate startOfMonth = now.withDayOfMonth(1);

        System.out.println("\nTransactions for this month:");
        for (Transaction transaction : Ledger.ledger) {
            if (!transaction.getDate().isBefore(startOfMonth)) {
                System.out.println(transaction);
            }
        }
    }

    public static void previousMonth() {
        LocalDate now = LocalDate.now();
        LocalDate startOfPreviousMonth = now.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfPreviousMonth = now.withDayOfMonth(1).minusDays(1);

        System.out.println("\nTransactions for previous month:");
        for (Transaction transaction : Ledger.ledger) {
            LocalDate transDate = transaction.getDate();
            if (!transDate.isBefore(startOfPreviousMonth) && !transDate.isAfter(endOfPreviousMonth)) {
                System.out.println(transaction);
            }
        }
    }

    public static void yearToDate() {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();

        System.out.println("\nTransactions for this year:");
        for (Transaction transaction : Ledger.ledger) {
            if (transaction.getDate().getYear() == currentYear) {
                System.out.println(transaction);
            }
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

    public static void searchByVendor() {
        System.out.println("Enter vendor name to search:");
        String vendorName = scanner.nextLine();

        System.out.println("\nTransactions for vendor: " + vendorName);
        boolean found = false;
        for (Transaction transaction : Ledger.ledger) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }
}