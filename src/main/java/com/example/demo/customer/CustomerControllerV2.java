package com.example.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
@Deprecated
public class CustomerControllerV2 {

    private final CustomerService customerService;

    public CustomerControllerV2 (CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List <Customer> getCustomer () {
        return Arrays.asList (
                        new Customer (1L, "Addisu","myPass"),
                        new Customer (2l, "Dagne","DagnePassword"));
                  }

    @PostMapping
    void createNewCustomer (@RequestBody Customer customer) {
        System.out.println ("Post Request");
        System.out.println (customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer (@PathVariable("customerId") Long customerId) {
        System.out.println ("Delete Request for customer with ID" + customerId);
    }

    @PutMapping(path = "{customerID}")
    void updateCustomer (@RequestBody Customer customer, @PathVariable("customerID") Long id) {
        Long oldCustomerId = customer.getId ();
        System.out.println ("Update customer request...");
        System.out.println (customer);
    }
}