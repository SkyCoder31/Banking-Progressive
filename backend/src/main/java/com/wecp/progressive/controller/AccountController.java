package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts()throws SQLException {
        return new ResponseEntity<List<Accounts>>(accountService.getAllAccounts(),HttpStatus.OK);
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(Integer accountId)throws SQLException {
        return new ResponseEntity<Accounts>(accountService.getAccountById(accountId),HttpStatus.OK);
    }
    @GetMapping("/user/{customerId}")
    public ResponseEntity<List<Accounts>> getAccountsByUser(@PathVariable String customerId) throws SQLException {
       //return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(accountService.getAccountsByUser(Integer.parseInt(customerId)),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> addAccount(Accounts accounts)throws SQLException {
        return new ResponseEntity<Integer>(accountService.addAccount(accounts),HttpStatus.CREATED);
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(Integer accountId, Accounts accounts)throws SQLException{
        accounts.setAccountId(accountId);
        accountService.updateAccount(accounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(Integer accountId)throws SQLException {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}