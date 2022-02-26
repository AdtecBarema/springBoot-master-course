package com.example.demo.customer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List <Customer> getCustomers () {
        return customerService.getcustomers ();
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
         System.out.println ("Update customer request...");
        System.out.println (customer);
    }

    @GetMapping(path="{customerId}")
    public Customer getCustomers (@PathVariable ("customerId") Long id){
        return
                customerService.getcustomers ()
                .stream ()
                .filter (cust->cust.getId ().equals (id))
                .findFirst ()
                .orElseThrow (()-> new IllegalStateException ("Customer not found "));
    }
}