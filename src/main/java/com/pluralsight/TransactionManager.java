package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    public static List<Transaction> transactions(String fileName){
        List<Transaction> transactions = new ArrayList<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();

            String transactionString;
            while((transactionString= bufferedReader.readLine())!=null){
                String[] transArr = transactionString.split("\\|");
                Transaction trans = new Transaction();

                // convert each part to the correct data type
                LocalDate date = LocalDate.parse(transArr[0]);
                LocalTime time = LocalTime.parse(transArr[1]);
                String description = transArr[2];
                String vendor = transArr[3];
                double amount = Double.parseDouble(transArr[4]);

                // Create a new transaction object with the data
                Transaction transaction = new Transaction((date),time,description,vendor,amount);

                // Add the transaction to our list
                Ledger.ledger.add(transaction);

            }



        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return transactions;
    }
    public static void saveInfoTransaction(Transaction t){

        try {
            // open the file for writing (true append to the end of file)
            FileWriter fileWriter = new FileWriter("transactions.csv" , true);

            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);


            // format the transactions data as cvs line
            String text = t.getDate() + "|" +
                    t.getTime() + "|" +
                    t.getDescription() + "|" +
                    t.getVendor() + "|" +
                    t.getAmount();

            // write the transaction to the file
            bufWriter.newLine();
            bufWriter.write(text);
             //

            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }

    }
}
