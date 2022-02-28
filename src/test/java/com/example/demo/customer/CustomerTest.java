package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//this helps to bring the actual test object for the test
class CustomerTest {
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp () {
        underTest = new CustomerService (customerRepository);
    }

    @AfterEach
    void tearDown () {
        customerRepository.deleteAll ();
    }

    @Test
    void getCustomers () {
        //Given
        Customer jamila = new Customer (1L, "jamila",
                                        "hello",
                                        "jamila@gmail.com"
        );

        Customer ali = new Customer (2L, "ali",
                                     "hello",
                                     "ali@gmail.com"
        );

        //When
        customerRepository.saveAll (Arrays.asList (jamila, ali));

        List <Customer> customers = underTest.getcustomers ();

        //Then
        assertEquals (2, customers.size ());

    }

    @Test
    void getCustomer () {

        //Given
        Customer jamila = new Customer (1L, "jamila",
                                        "hello",
                                        "jamila@gmail.com"
        );
        //When
        customerRepository.save (jamila);
        Customer actual = underTest.getCustomer (1L);

        //Then
        assertEquals (1l, actual.getId ());

    }
}