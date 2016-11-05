package com.abc.Impl.model;

/**
 * Created by Mtui on 10/20/16.
 */
public class AccountChecking extends Account {

    private final double INTREST_LESS_MINIMUM = 0.001;

    public AccountChecking(AccountType accountType) {
        super(accountType);
    }

    public double interestEarned(double amount) {
        return amount * INTREST_LESS_MINIMUM;
    }
}
