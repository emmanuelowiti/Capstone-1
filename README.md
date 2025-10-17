
🧾 Accounting Ledger Application

A Java CLI (Command Line Interface) application that helps users track their financial transactions — including deposits, payments, and ledger reports — all stored in a transactions.csv file.

## 📚 Table of Contents

1.Project Overview

2.Features

3.How It Works

4.Project Structure

5.Sample Data Format

6.How to Run

7.Screens & Navigation

8.Technologies Used

9.Example Output

10.Interesting Code Snippet

11.Future Improvements

---

## 🧠 How It Works


Data Loading:
The application reads all existing transactions from transactions.csv using BufferedReader.

Adding Entries:
When users add a deposit or payment, their input is formatted and appended to the file using BufferedWriter.

Filtering and Displaying:
The program displays lists of transactions (all, deposits, payments) in descending order (newest first).

Reporting:
Users can filter transactions by date, month, year, or vendor.

🧩 Project Overview

This project was developed as part of the Java Development Fundamentals Capstone.
It simulates a simple accounting ledger system where a user can:

Add deposits 💰

Record payments 💳

View all transactions 📘

Generate reports 📊

### Example Data File
`transaction.csv`
```
date|time|description|vendor|amount
2025-10-06|09:15|Deposit paycheck|Acme Corp|2500.00
2025-10-06|12:30|Coffee purchase|Starbucks|-5.25
2025-10-08|13:10|Lunch with client|Olive Garden|-34.60
2025-10-09|10:00|Freelance payment|Upwork|850.00

```

---

## Code Examples

Here’s an example of what your **Kitten class** might look like:

```java
public class Ledger {
    public static ArrayList<Transaction> ledger = new ArrayList<>();

    public static void makeDeposit(double amount,String vendor, String description){
        ledger.add(0,new Transaction(LocalDate.now(),LocalTime.now(),description,vendor, amount));
    }
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

```

---

### Example Output
💰 Add a new transaction

Enter description: Grocery Shopping

Enter vendor: Walmart

Enter amount :82.49

✅ Transaction saved successfully!


Ledger:

2025-10-06|09:15|Deposit paycheck|Acme Corp|2500.00

2025-10-06|12:30|Coffee purchase|Starbucks|-5.25

2025-10-07|18:45|Grocery shopping|Walmart|-82.49


---

🚀 **Future Improvements**

1.Add category filtering (e.g., “Food”, “Rent”, “Utilities”)

2.Generate summary reports as CSV or PDF

3.Add balance calculations (total income vs. expenses)

4.Add data validation and confirmation prompts

5.Create a GUI version using JavaFX or Swing


---

## Author
Created by Owiti Emmanuel Okoth.
