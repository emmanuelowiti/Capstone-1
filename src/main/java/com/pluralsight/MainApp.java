package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean isRunning = false; //keep the program running if set to true

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
            //one for deposit, ledger, make payment, invalid choice, exit
            case 1:
                addDeposit();
                break;
            case 2:
                makePayment();
                break;
            case 3:
                ledgerScreen();
                break;
            case 4:
                System.out.println("Exit the program");
                return true;
            default:
                System.out.println("Invalid choice! Try again");
                break;
        }
        return false;
    }
    //method to deposit
    public static void addDeposit(){
        //get the amount
        //get the vendor
        //get description
    }
    public static void makePayment(){

    }
    public static void ledgerScreen(){
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

        switch(choice){
            case 1://show all transactions
            case 2://show all deposits
            case 3://show all payments(negative)
            case 4://Show reports
            case 5://Got to homepage
                homeScreen();
            default://Handle any outside inputs
                System.out.println("Invalid choice! Try again");
            break;
        }
    }
}

