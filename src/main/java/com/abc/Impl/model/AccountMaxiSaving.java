package com.abc.Impl.model;

/**
 * Created by Mtui on 10/20/16.
 */
public class AccountMaxiSaving extends Account {

    private final double MINIMUM_DEPOSIT = 1000;
    private final double INTEREST_MINIMUM = 0.02;
    private final double INTEREST_GREATER_MINIMUM = 0.05;

    public AccountMaxiSaving(AccountType accountType) {
        super(accountType);
    }

    public double interestEarned(double amount) {
        if (amount <= MINIMUM_DEPOSIT)
            return amount * INTEREST_MINIMUM;
        if (amount <= 2 * MINIMUM_DEPOSIT)
            return 20 + (amount-MINIMUM_DEPOSIT) * INTEREST_GREATER_MINIMUM;
        return 70 + (amount-2 * MINIMUM_DEPOSIT) * 0.1;
    }

}
