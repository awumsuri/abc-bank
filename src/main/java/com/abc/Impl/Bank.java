package com.abc.Impl;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        StringBuilder summary = new StringBuilder("Customer Summary");

        for (Customer c : customers)
            summary.append("\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")");

        return summary.toString();
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;

        for(Customer c: customers)
            total += c.totalInterestEarned();

        return total;
    }

    public String getFirstCustomer() {
        Customer customer = this.customers.get(0);

        if(customer != null)
            return customer.getName();

        return "Bank has no Customers at this time :(";
    }
}
