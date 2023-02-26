package com.app.service;

import com.app.entity.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStudentService {

	Mono<Student> save(Student student);
	Mono<Student> getOne(String id);
	Flux<Student> findAll();
	Mono<Void> delete(String id);
}
