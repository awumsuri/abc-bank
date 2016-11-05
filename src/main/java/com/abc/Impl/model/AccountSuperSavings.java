package com.abc.Impl.model;

/**
 * Created by Mtui on 10/20/16.
 */
public class AccountSuperSavings extends Account {

    private final double MINIMUM = 4000;

    public AccountSuperSavings(AccountType accountType) {
        super(accountType);
    }

    public double interestEarned(double amount) {
        if (amount <= MINIMUM)
            return 20;
        return 0;
    }
}
