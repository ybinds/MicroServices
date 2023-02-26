package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.consumer.DepartmentConsumerFeign;
import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private DepartmentConsumerFeign consumer;
	
	@Override
	public Employee getEmployeeById(Integer id) {
		Employee e=null;
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent()) {
			e = emp.get();
			System.out.println(e);
			e.setEmpDeptName(consumer.getDeptName(e.getEmpDeptId()));
		}
		return e;
	}

}
