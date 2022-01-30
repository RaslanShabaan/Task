package com.example.demo.ServiceImplmentations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Employee;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	@Autowired
	com.example.demo.Reposatories.EmployeeReposatory EmployeeReposatory;
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findAll();
	}

	public Employee findEmployeeById(long theId) {
		// TODO Auto-generated method stub
		return EmployeeReposatory.findById(theId).orElse(null);
	}

	public void saveEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		EmployeeReposatory.save(Employee);
	}

	public void updateEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		EmployeeReposatory.save(Employee);
	}

	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		EmployeeReposatory.deleteById(theId);
	}

}
