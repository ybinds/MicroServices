package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer empId;
	@Column(name="name")
	private String empName;
	@Column(name="email")
	private String empEmail;
	@Column(name="phone")
	private String empPhone;
	@Column(name="gender")
	private String empGender;
	@Column(name="dept_id")
	private Integer empDeptId;
	@Transient
	private String empDeptName;
}