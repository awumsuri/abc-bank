package com.abc.Impl;

import java.util.Calendar;
import java.util.Date;

public class Transaction {

    private final double amount;
    private final Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = Calendar.getInstance().getTime();
    }

    public double getAmount() {
        return amount;
    }

}
