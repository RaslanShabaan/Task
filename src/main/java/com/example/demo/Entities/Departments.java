package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "Departments-gen", sequenceName = "Departments", initialValue = 200, allocationSize = 1)
@Table(name = "Departments")

public class Departments {

	@Column(name = "DEPARTMENT_ID")
	private Long department_id;

	@Column(name = "DEPARTMENT_NAME")
	private String department_name;

	@Column(name = "MANGER_ID")
	private Long manager_id;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department-gen")
	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

}
