package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOGGER= LoggerFactory.getLogger (CustomerService.class);

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService (
             CustomerRepository customerRepo1) {
        this.customerRepository = customerRepo1;
    }

    List <Customer> getcustomers () {
        LOGGER.info ("Get customer was called");

        return customerRepository.findAll ();
    }

     Customer getCustomers (@PathVariable("customerId") Long id){

        return
                getcustomers ()
                        .stream ()
                        .filter (cust->cust.getId ().equals (id))
                        .findFirst ()
                        .orElseThrow (()-> {
                            NotFoundException notFoundException=new NotFoundException ("Sorry, but customer with Id: "+id+" not found");
                            LOGGER.error ("error in getting customer {}",id, notFoundException);
                            return notFoundException;
                        });
    }
}