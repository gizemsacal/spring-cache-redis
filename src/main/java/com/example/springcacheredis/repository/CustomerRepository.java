package com.example.springcacheredis.repository;

import com.example.springcacheredis.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
Optional<Customer> findById(Long id);

}
