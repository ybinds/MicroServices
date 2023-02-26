package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/create")
	public Mono<Student> saveStudent(
			@RequestBody Student student){
		return service.save(student);
	}
	
	@GetMapping("/fetch/{id}")
	public Mono<Student> getOne(@PathVariable String id){
		return service.getOne(id);
	}
	
	@GetMapping("/fetchAll")
	public Flux<Student> getAll(){
		return service.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteStudent(@PathVariable String id){
		return service.delete(id);
	}
}
