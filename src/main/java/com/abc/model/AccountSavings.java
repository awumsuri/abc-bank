package com.abc.model;

import com.abc.model.Account;

/**
 * Created by Mtui on 10/20/16.
 */
public class AccountSavings extends Account{

    public AccountSavings(AccountType accountType) {
        super(accountType);
    }

    private final double MINIMUM_DEPOSIT = 1000;
    private final double INETREST_LESS_MINIMUM = 0.001;
    private final double INETREST_GREATER_MINIMUM = 0.002;

    public double interestEarned(double amount) {
       if (amount <= MINIMUM_DEPOSIT)
           return (amount * INETREST_LESS_MINIMUM);
       else
           return (1 + (amount-MINIMUM_DEPOSIT) * INETREST_GREATER_MINIMUM);
    }
}
