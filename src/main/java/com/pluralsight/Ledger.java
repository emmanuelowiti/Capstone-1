package com.pluralsight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ledger {
    private final ArrayList<Transaction> transactions;

    public Ledger(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}

