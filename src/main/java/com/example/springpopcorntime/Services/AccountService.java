package com.example.springpopcorntime.Services;


import com.example.springpopcorntime.Model.Account;
import com.example.springpopcorntime.Model.AccountViewModel;

import java.util.List;

public interface AccountService {
    AccountViewModel login(String emailId);
    public List<Account> getAllAccounts();
}
