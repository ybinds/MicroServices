package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	@Override
	public List<Department> getAllDepartments() {
		return repo.findAll();
	}
	
	@Override
	public Department getDeptById(Integer id) {
		System.out.println(id);
		return repo.findById(id).get();
	}

	@Override
	public Integer saveDepartment(Department d) {
		Department dept = repo.save(d);
		return dept.getDeptId();
	}

	@Override
	public void deleteDepartment(Integer id){
		repo.delete(this.getDeptById(id));
	}

}