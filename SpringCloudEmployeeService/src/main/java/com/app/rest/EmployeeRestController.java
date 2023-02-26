package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.IEmployeeService;

@RestController
@RefreshScope
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	@Value("${my.app.title}")
	private String title;
	
	@GetMapping("/employee/get/{id}")
	public ResponseEntity<String> getEmployeeById(@PathVariable("id") Integer id){
		Employee emp = service.getEmployeeById(id);
		return ResponseEntity.ok(emp.getEmpDeptName()+"  "+emp.getEmpName()+"  "+title);
	}
}
