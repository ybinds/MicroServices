package com.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DEPARTMENTAPI")
public interface DepartmentConsumerFeign {

	@GetMapping("/department/get/{id}")
	public String getDeptName(@PathVariable("id") Integer id);
}
