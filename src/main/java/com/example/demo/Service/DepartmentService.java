package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Departments;


public interface DepartmentService {
	public List<Departments> findAllDepartments();

	public Departments findDepartmentsById(long theId);

	public void saveDepartments(Departments Departments);

	public void updateDepartments(Departments Departments);

	public void deleteById(long theId);
}
