package com.example.springcacheredis.controller;

import com.example.springcacheredis.model.Customer;
import com.example.springcacheredis.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;
    private Object Customer;

    @Cacheable(value = "Customer")
    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        try {
            System.out.println("5 saniye uyudu.");
            Thread.sleep(5000);
            System.out.println("uykudan sonra devam etti.");
        } catch (InterruptedException ex) {
            System.out.println(" uyku kesintiye uğradı.");
        }
        return customerService.getCustomers();

    }

    @Cacheable(value = "Customer")
    @PostMapping("/customer")
    public Customer creatCustomer(@RequestBody Customer customer) { //method
        try {
            System.out.println("5 saniye uyudu.");
            Thread.sleep(5000);
            System.out.println("uykudan sonra devam etti.");
        } catch (InterruptedException ex) {
            System.out.println("uyku kesintiye uğradı.");
        }
        return customerService.save(customer);
    }

    @CachePut(cacheNames = "Customer", key = "'Customer#'+ #id")
    @PutMapping("Customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        try {
            System.out.println("5 saniye uyudu.");
            Thread.sleep(5000);
            System.out.println("uykudan sonra devam etti.");
        } catch (InterruptedException ex) {
            System.out.println("uyku kesintiye uğradı.");
        }
        customer.setId(id);
        return customerService.save(customer);
    }
@CacheEvict(cacheNames = "Customer" , allEntries = true)
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
    try {
        System.out.println("5 saniye uyudu.");
        Thread.sleep(5000);
        System.out.println("uykudan sonra devam etti.");
    } catch (InterruptedException ex) {
        System.out.println("uyku kesintiye uğradı.");
    }
      customerService.deleteCustomer(id);
}
}
