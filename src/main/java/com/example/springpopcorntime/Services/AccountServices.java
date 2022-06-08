package com.example.springpopcorntime.Services;

import com.example.springpopcorntime.Helper.AccountConverter;
import com.example.springpopcorntime.Model.Account;
import com.example.springpopcorntime.Model.AccountViewModel;
import com.example.springpopcorntime.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServices implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountViewModel login(String emailId)
    {
        Account account = accountRepository.findByemailId(emailId);
        AccountViewModel accountViewModel = new AccountViewModel();
        if(account == null) {
            accountViewModel.setLogged(false);
            return accountViewModel;
        }
        accountViewModel = AccountConverter.convertAccountToViewModel(account);
        accountViewModel.setLogged(true);
        return accountViewModel;
    }
}
