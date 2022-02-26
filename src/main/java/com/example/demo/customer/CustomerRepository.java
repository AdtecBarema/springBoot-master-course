package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class CustomerRepository  implements CustomerRepo {

    @Override
        //TODO connect to real DB
        public List <Customer> getCustomers () {
            return Arrays.asList (
                    new Customer (1L, "TODO connect to real DB")

            );
          }
}