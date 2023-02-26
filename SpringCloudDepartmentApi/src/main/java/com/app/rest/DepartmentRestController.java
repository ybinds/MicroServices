package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.service.IDepartmentService;

@RestController
public class DepartmentRestController {

	@Autowired
	private IDepartmentService service;
	
	@GetMapping("/department/get/{id}")
	public ResponseEntity<String> getDeptName(@PathVariable("id") Integer id) {
		System.out.println(id);
		Department d = service.getDeptById(id);
		System.out.println(d);
		return ResponseEntity.ok(d.getDeptName());
	}
	
}
