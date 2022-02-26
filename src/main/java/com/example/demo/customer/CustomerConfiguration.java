package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value ("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println ("Hello, this is usage of the @Bean annotation," +
                                        " which is to be instantiated when the application bootstraps");
        };
    }
    /**
     *  We can use @Bean annotation to have full control of switching implementations.
     * In our case we can instantiate implementation of the CustomerRepo from two distinict classes:"CustomerFakeRepository" or "customerRepository"
     * Class instantiated with  @Bean annotation don't need to have  @Component/@Repository or @Service annotation,
     *  This will avoid possible confusion of creating the different objects from the same bean.

     */
//    @Bean
//    CustomerRepo customerRepo(){
//        System.out.println ("useFakeCustomerRepo = "+useFakeCustomerRepo);
//        return useFakeCustomerRepo?
//                new CustomerFakeRepository ():
//                new CustomerRepository ();
//    }
}