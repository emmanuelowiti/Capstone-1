
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

## About the Project

The **Kitten Directory App** helps you manage and display information about kittens from a simple data file.  
It’s a great exercise to understand:
- How to work with **objects and attributes**
- How to **read and write files**
- How to create **clean, structured code**

> 💡 *Fun tip:* You can replace “kittens” with any dataset — books, songs, planets, or Pokémon — and the structure will still make sense.

---

🧩 Project Overview

This project was developed as part of the Java Development Fundamentals Capstone.
It simulates a simple accounting ledger system where a user can:

Add deposits 💰

Record payments 💳

View all transactions 📘

Generate reports 📊

## Getting Started

### Prerequisites
You’ll need:
- A programming language of your choice (e.g., Java, Python, C#)
- A text editor or IDE
- A CSV or JSON file with kitten data

### Example Data File
`kittens.csv`
```

name,breed,age,color
Luna,British Shorthair,2,Grey
Milo,Siamese,1,Cream
Nala,Maine Coon,3,Brown

```

### Running the Project
You can run it from your terminal or IDE once you’ve implemented your logic:

```bash
javac src/Main.java
java src/Main
```


---

## Folder Structure

```
kitten-directory/
│
├── src/
│   ├── models/
│   │   └── Kitten.java
│   ├── data/
│   │   └── kittens.csv
│   └── Main.java
│
├── images/
│   └── kitten_banner.png
│
└── README.md
```

---

## Code Examples

Here’s an example of what your **Kitten class** might look like:

```java
public class Kitten {
    private String name;
    private String breed;
    private int age;

    public Kitten(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("%s is a %d-year-old %s.%n", name, age, breed);
    }
}
```

---

## Images

Here’s an example of an embedded image (make sure the file exists):

![Cute kitten looking at code](./images/zia.png)

Or link to a kitten gif online:
![Kitten gif](https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif)

---

## Markdown Reference

### Text Styles

* **Bold text**
* *Italic text*
* ~~Strikethrough~~
* `Inline code`

### Lists

* Unordered list

    * Nested item
* Ordered list

    1. Step one
    2. Step two
    3. Step three


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

### Task List

* [x] Create `Kitten` class
* [x] Read kittens from file
* [ ] Add save functionality
* [ ] Add image display feature

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
