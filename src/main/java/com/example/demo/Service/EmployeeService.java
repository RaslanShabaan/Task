package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Employee;



public interface EmployeeService {
	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(long theId);

	public void saveEmployee(Employee Employee);

	public void updateEmployee(Employee Employee);

	public void deleteById(long theId);

}
