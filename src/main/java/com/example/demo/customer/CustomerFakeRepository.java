package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Qualifier("fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List <Customer> getCustomers () {
        return Arrays.asList (
                new Customer (1L, "James Bond","password"),
                new Customer (2L, "Jamila Ahmed", "password")
        );
    }
}
