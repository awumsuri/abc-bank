package com.abc.Impl.model;

import com.abc.Impl.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mtui on 10/20/16.
 */
public abstract class Account {

    protected final AccountType accountType;
    protected List<Transaction> transactions;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;

        for (Transaction t: transactions)
            amount += t.getAmount();

        return amount;
    }

    public double sumTransactions() {
        return checkIfTransactionsExist(true);
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public abstract double interestEarned(double amount);

    public double getInterestedEarned() {
        double total = 0.0;

        for(Transaction t : this.transactions) {
            total += t.getAmount();
        }

        return total;
    }

}
