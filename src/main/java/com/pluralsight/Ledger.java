package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ledger {
    public static ArrayList<Transaction> ledger = new ArrayList<>();

    public static void makeDeposit(double amount, String vendor, String description) {
        Transaction t = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        ledger.add(0, t);
        TransactionManager.saveInfoTransaction(t);
    }

    public static void addPayment(double amount, String vendor, String description) {
        Transaction t = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, (-1 * amount));
        ledger.add(0, t);
        TransactionManager.saveInfoTransaction(t);
    }

    public static void showAllTransactions() {
        System.out.println("\n=== All Transactions ===");
        for (Transaction t : ledger) {
            System.out.println(t);
        }
        System.out.println();
    }

    public static void showAllDeposits() {
        System.out.println("\n=== All Deposits ===");
        for (Transaction t : ledger) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
        System.out.println();
    }

    public static void showAllPayments() {
        System.out.println("\n=== All Payments ===");
        for (Transaction t : ledger) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
        System.out.println();
    }
}