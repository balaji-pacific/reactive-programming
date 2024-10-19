package com.reactive.prog.controller;

import com.reactive.prog.dto.Customer;
import com.reactive.prog.service.ReactiveProgrammingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class ReactiveProgrammingController {

    @Autowired
    ReactiveProgrammingService reactiveProgrammingService;

    @GetMapping("")
    public List<Customer> getCustomer(){
        return reactiveProgrammingService.getAllCustomer();
    }


    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomerStream(){
        return reactiveProgrammingService.getAllCustomerStream();
    }
}
