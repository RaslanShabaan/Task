package com.example.demo.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "Employee-gen", sequenceName = "Employee", initialValue = 200, allocationSize = 1)
@Table(name = "Employee")
public class Employee {

	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private Long phone_number;
	
	@Column(name = "hire_date")
	private Date hire_date;
	
	@Column(name = "salary")
	private Double salary;
	
	
	@Column(name = "manager_id")
	private Long manager_id;
	
	
	private Departments department_id;
	
	
	@Column(name = "employee_id")
	private Long employee_id;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department-gen")
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Long getManager_id() {
		return manager_id;
	}
	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	public Departments getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Departments department_id) {
		this.department_id = department_id;
	}

}
