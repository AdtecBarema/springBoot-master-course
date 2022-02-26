package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService (
             CustomerRepository customerRepo1) {
        this.customerRepository = customerRepo1;
    }

    List <Customer> getcustomers () {
        return customerRepository.findAll ();
    }

    public Customer getCustomers (@PathVariable("customerId") Long id){
        return
                getcustomers ()
                        .stream ()
                        .filter (cust->cust.getId ().equals (id))
                        .findFirst ()
                        .orElseThrow (()-> new NotFoundException ("Sorry, but customer with Id: "+id+" not found"));
    }
}