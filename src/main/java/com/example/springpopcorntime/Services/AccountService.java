package com.example.springpopcorntime.Services;


import com.example.springpopcorntime.Model.Account;
import com.example.springpopcorntime.Model.AccountViewModel;

public interface AccountService {
    AccountViewModel login(String emailId);
}
