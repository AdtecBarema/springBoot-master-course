package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService (
             CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List <Customer> getcustomers () {

        return customerRepo.getCustomers ();
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
