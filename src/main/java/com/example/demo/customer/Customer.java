package com.example.demo.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {
    @Id
    private  Long id;
    @NotBlank
    private  String name;
    @NotBlank
    private  String password;

    private  String email;

    public Customer () {
    }

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