package com.example.demo.Reposatories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entities.Departments;
import com.example.demo.Entities.Employee;

public interface DepartmentReposatory extends JpaRepository<Departments, Long>{
	@Query(value = "select * from Department" , nativeQuery = true)
	List<Page> AllDepartments();
}
