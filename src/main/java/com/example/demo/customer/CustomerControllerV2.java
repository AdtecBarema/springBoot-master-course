package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping(path = "api/v2/customers")

public class CustomerControllerV2 {


    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2 (CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List <Customer> getCustomers () {
        return customerService.getcustomers ();
    }

    @PostMapping
    void createNewCustomer (@RequestBody @Valid Customer customer) {

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

    @GetMapping(path = "{customerId}")
    public Customer getCustomers (@PathVariable("customerId") Long id) {
        return
                customerService.getCustomers (id);
    }


    @GetMapping(path = "{customerId}/exception")
    public Customer getCustomerException (@PathVariable("customerId") Long id) {
        throw
                new ApiRequestException ("ApiRequestException for customer " + id);

    }

}