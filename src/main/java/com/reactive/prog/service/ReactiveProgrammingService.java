package com.reactive.prog.service;

import com.reactive.prog.dao.ReactiveProgrammingDAO;
import com.reactive.prog.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ReactiveProgrammingService {

    @Autowired
    public ReactiveProgrammingDAO reactiveProgrammingDAO;

    public List<Customer> getAllCustomer(){
        Long start = System.currentTimeMillis();
        final List<Customer> customer = reactiveProgrammingDAO.getCustomer();
        Long end = System.currentTimeMillis();
        System.out.println("Time took to processing the " + (end - start));
        return customer;
    }

    public Flux<Customer> getAllCustomerStream() {
        Long start = System.currentTimeMillis();
        final Flux<Customer> customer = reactiveProgrammingDAO.getCustomerStream();
        Long end = System.currentTimeMillis();
        System.out.println("Time took to processing the " + (end - start));
        return customer;
    }
}
