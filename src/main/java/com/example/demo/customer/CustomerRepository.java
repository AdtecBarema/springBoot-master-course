package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public interface CustomerRepository  extends JpaRepository<Customer, Long>  {


}