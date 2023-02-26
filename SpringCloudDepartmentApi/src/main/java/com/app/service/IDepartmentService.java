package com.app.service;

import java.util.List;

import com.app.entity.Department;

public interface IDepartmentService {

	List<Department> getAllDepartments();
	Department getDeptById(Integer id);
	Integer saveDepartment(Department d);
	void deleteDepartment(Integer id);
}
