package com.reactive.prog.dao;

import com.reactive.prog.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ReactiveProgrammingDAO {

    public static void delaying(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomer(){
        return IntStream.rangeClosed(1, 20)
                .peek(ReactiveProgrammingDAO::delaying)
                .peek(i -> System.out.println("procesing count " + i ))
                .mapToObj(i -> new Customer(i, "Customer ".concat(String.valueOf(i))))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1, 20).log()
                .doOnNext(i -> System.out.println("processing count " + i))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Customer(i, "Customer" + i));
    }
}
