package com.example.springpopcorntime.Helper;

import com.example.springpopcorntime.Model.Account;
import com.example.springpopcorntime.Model.AccountViewModel;

public class AccountConverter {
    public static AccountViewModel convertAccountToViewModel(Account account)
    {
        AccountViewModel vm = new AccountViewModel();
        vm.setId((account.getId()));
        vm.setFirstName(account.getFirstName());
        vm.setLastName(account.getLastName());
        vm.setEmailId(account.getEmailId());
        vm.setPassword(account.getPassword());
        return vm;
    }
}
