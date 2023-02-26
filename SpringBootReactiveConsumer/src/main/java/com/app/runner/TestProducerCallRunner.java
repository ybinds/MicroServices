package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.entity.Student;

import reactor.core.publisher.Flux;

@Component
public class TestProducerCallRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		
		//1. Create Web Client Object
		WebClient client = WebClient.create("http://localhost:9090/student");
		
		// Adding data to MongoDB
//		Mono<Student> student = client
//			.post()
//			.uri("/create")
//			.body(Mono.just(new Student("1002A", "Bhanu", 400.0)), Student.class)
//			.retrieve()
//			.bodyToMono(Student.class);
//		System.out.println("From Consumer post ----->");
//		student.subscribe(System.out::println);
		
		// Retrieve data from MongoDB
//		Mono<Student> student = client
//			.get()
//			.uri("/fetch/1002A")
//			.retrieve()
//			.bodyToMono(Student.class);
//		System.out.println("From Consumer get one ----->");
//		student.subscribe(System.out::println);
		
		// Retrieve all data from MongoDB
		Flux<Student> students = client
			.get()
			.uri("/fetchAll")
			.retrieve()
			.bodyToFlux(Student.class);
		students.doOnNext(System.out::println).blockLast();
	}

}
