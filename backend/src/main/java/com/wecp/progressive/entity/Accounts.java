package com.wecp.progressive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Accounts implements Comparable<Accounts>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customers customers;
    private double balance;

    public Accounts() {
    }

    public Accounts(int accountId, int customerId, double balance) {
        this.accountId = accountId;
        this.customers.setCustomerId(customerId);
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomerId(Customers customers) {
        this.customers= customers;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(Accounts o) {
        return Double.compare(this.balance, o.balance);
    }

}