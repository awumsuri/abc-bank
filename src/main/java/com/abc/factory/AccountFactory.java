package com.abc.factory;

import com.abc.model.*;

/**
 * Created by Mtui on 10/20/16.
 */
public class AccountFactory {

    public static Account createAccount(AccountType accountType) throws IllegalArgumentException {

        switch (accountType) {
            case SAVINGS:
                return new AccountSavings(accountType);
            case CHECKING:
                return new AccountChecking(accountType);
            case MAXI_SAVINGS:
                return new AccountMaxiSaving(accountType);
            case SUPER_SAVINGS:
                return new AccountSuperSavings(accountType);
            default:
                throw new IllegalArgumentException("AccountType not found");
        }
    }

}
