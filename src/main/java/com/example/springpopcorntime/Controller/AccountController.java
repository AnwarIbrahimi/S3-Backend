package com.example.springpopcorntime.Controller;

import com.example.springpopcorntime.Exception.ResourceNotFoundException;
import com.example.springpopcorntime.Model.Account;
import com.example.springpopcorntime.Model.AccountViewModel;
import com.example.springpopcorntime.Repository.AccountRepository;
import com.example.springpopcorntime.Services.AccountService;
import com.example.springpopcorntime.Services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountServices accountServices;

    //get all accounts
    @GetMapping("/accounts")
    public List<Account> getAllAccounts() { return accountRepository.findAll(); }

    // create account rest api
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) { return accountRepository.save(account); }
    
    // get account by id rest api
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist with this id :" + id));
        return ResponseEntity.ok(account);
    }
    
    // update account rest api
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist with this id :" + id));
        
        account.setFirstName(accountDetails.getFirstName());
        account.setLastName(accountDetails.getLastName());
        account.setEmailId(accountDetails.getEmailId());

        Account updatedAccount = accountRepository.save(account);
        return ResponseEntity.ok(updatedAccount);
    }

    // delete account rest api
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account does not exist with this id :" + id));

        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/email/{emailId}")
    public AccountViewModel Login(@PathVariable String emailId ) { return accountServices.login(emailId); }
}
