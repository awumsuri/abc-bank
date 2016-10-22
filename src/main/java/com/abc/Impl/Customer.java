package com.abc.Impl;

import com.abc.model.Account;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);

        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;

        for (Account a : accounts)
            total += a.interestEarned(a.getInterestedEarned());

        return total;
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder();

        statement.append("Statement for " + name + "\n");
        double total = 0.0;

        for (Account a : accounts) {
            statement.append("\n" + statementForAccount(a) +"\n");
            total += a.sumTransactions();
        }

        statement.append("\nTotal In All Accounts " + toDollars(total));

        return statement.toString();
    }

    private String statementForAccount(Account a) throws IllegalArgumentException {
        StringBuilder s = new StringBuilder();

       //Translate to pretty account type
        switch(a.getAccountType()){
            case CHECKING:
                s.append("Checking Account");
                break;
            case SAVINGS:
                s.append("Savings Account");
                break;
            case MAXI_SAVINGS:
                s.append("Maxi Savings Account");
                break;
            default:
                throw new IllegalArgumentException("AccountType Does not Exist");
        }

        s.append(System.getProperty("line.separator"));

        //Now total up all the transactions
        double total = 0.0;

        for (Transaction t : a.getTransactions()) {
            s.append("  " + (t.getAmount() < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n");
            total += t.getAmount();
        }
        s.append("Total " + toDollars(total));

        return s.toString();
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
