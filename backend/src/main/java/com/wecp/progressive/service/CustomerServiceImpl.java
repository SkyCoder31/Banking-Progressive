package com.wecp.progressive.service;

import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.entity.Customers;

import java.util.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CustomerServiceImpl implements CustomerService {

    private static List<Customers> cusList = new ArrayList<>();

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        return -1;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {

    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {

    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        return null;
    }

    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        return cusList;
    }

    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        cusList.add(customers);
        return cusList;
    }

    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList(){
       List<Customers> sortCus=cusList;
       Collections.sort(sortCus);
       return sortCus;
    }

    @Override
    public void emptyArrayList() {
        cusList=new ArrayList<>();
    }
}