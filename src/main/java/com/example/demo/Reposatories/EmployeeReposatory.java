package com.example.demo.Reposatories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entities.Employee;

public interface EmployeeReposatory extends JpaRepository<Employee, Long>{
	@Query(value = "select * from Employee" , nativeQuery = true)
	List<Page> AllEmployees();
}
