package com.example.springcacheredis.service;

import com.example.springcacheredis.model.Customer;
import com.example.springcacheredis.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

@Cacheable("customerCache")
public List<Customer> getCustomers() {
    return customerRepository.findAll();
}
    @CacheEvict(value = "customersCache" , allEntries = true)
public Customer save(Customer customer){
      return customerRepository.save(customer);
}
public void deleteCustomer(Long id){
   customerRepository.deleteById(id);
}

}