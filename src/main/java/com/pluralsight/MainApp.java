package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        homeScreen();
        boolean isRunning = false; //keep the program running if set to true

        while (!isRunning) {}
            //homeScreen();// keeps running as long as set to true

       /*switch (choice) {
            //one for deposit, ledger, make payment, invalid choice, exit
            case 1:
                System.out.println("add deposit");
                break;
            case 2:
                System.out.println("make a payment");
                break;
            case 3:
                System.out.println("go to ledger");
                break;
            case 4:
                System.out.println("Exit the program");
                isRunning = false;
                break;
            default:
                System.out.println("Invalid choice! Try again");
                break;
        }
        }
        isRunning =false;
*/
        // homeScreen();
/*
        try{
            FileReader fReader = new FileReader("transactions.csv");
            BufferedReader bReader = new BufferedReader(fReader);
            bReader.readLine();
            String lineOfText;
            while((lineOfText = bReader.readLine() )!= null){
                System.out.println(lineOfText);

            }
            bReader.close();
        }catch(IOException e){
            System.out.println(e.getMessage());

        }

*/

    }

    public static void homeScreen() {
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
                System.out.println("add deposit");
                break;
            case 2:
                System.out.println("make a payment");
                break;
            case 3:
                System.out.println("go to ledger");
                break;
            case 4:
                System.out.println("Exit the program");

                break;
            default:
                System.out.println("Invalid choice! Try again");
                break;
        }

    }

}

