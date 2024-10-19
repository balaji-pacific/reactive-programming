package com.reactive.prog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

	@Test
	void sampleMono() {
		Mono<String> str = Mono.just("Example").log();
		str.subscribe(System.out::println);
	}

	@Test
	void sampleFlex(){
		Flux<?> strList = Flux.just("Java", " is" , " a", " wonderful", " language").log();
		strList.subscribe(System.out::println);

	}
}
