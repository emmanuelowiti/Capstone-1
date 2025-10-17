package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


;

public class Ledger {
    public static ArrayList<Transaction> ledger = new ArrayList<>();

    public static void makeDeposit(double amount,String vendor, String description){

        //adds the transaction to the top of the list
        ledger.add(0,new Transaction(LocalDate.now(),LocalTime.now(),description,vendor, amount));
    }
        //adds the transaction to the top of the list of transactions
    public static void addPayment(double amount, String vendor, String description){
        ledger.add(0,new Transaction(LocalDate.now(),LocalTime.now(),description,vendor, (-1* amount)));

    }
    public static void showAllTransactions(){
        for(Transaction t : ledger){
            System.out.println(t);
        }
    }
    public static void showAllDeposits(){
        for(Transaction t : ledger){
            if(t.getAmount()>0){
                System.out.println(t);
            }
        }
    }
    public static void showAllPayments(){
        for(Transaction t : ledger){
            if(t.getAmount()< 0){
                System.out.println(t);
            }
        }
    }
}
