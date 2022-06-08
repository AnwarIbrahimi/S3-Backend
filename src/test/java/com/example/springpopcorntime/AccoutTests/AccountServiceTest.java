package com.example.springpopcorntime.AccoutTests;


import com.example.springpopcorntime.Repository.AccountRepository;
import com.example.springpopcorntime.Services.AccountServices;
import com.example.springpopcorntime.Model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    private AccountServices accountServices;

    @BeforeEach
    void setUp() {
        accountServices = new AccountServices(accountRepository);
    }

    @Test
    void GetAllAccounts(){
        accountServices.getAllAccounts();
        verify(accountRepository).findAll();
    }
}
