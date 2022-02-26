package com.example.demo.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {
    private final Long id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String password;

    private final String email;

    public Customer (Long id,
                     String name,
                     String password,
                     String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getPassword () {
        return password;
    }

    @NotBlank
    @Email
    public String getEmail () {
        return email;
    }

    @Override
    public String toString () {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}