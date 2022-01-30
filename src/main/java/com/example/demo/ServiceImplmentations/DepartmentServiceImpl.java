package com.example.demo.ServiceImplmentations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Departments;
import com.example.demo.Reposatories.DepartmentReposatory;
import com.example.demo.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentReposatory DepartmentReposatory;
	
	public List<Departments> findAllDepartments() {
		// TODO Auto-generated method stub
		return DepartmentReposatory.findAll();
	}

	public Departments findDepartmentsById(long theId) {
		// TODO Auto-generated method stub
		return DepartmentReposatory.findById(theId).orElse(null);
	}

	public void saveDepartments(Departments Departments) {
		// TODO Auto-generated method stub
		DepartmentReposatory.save(Departments);
	}

	public void updateDepartments(Departments Departments) {
		// TODO Auto-generated method stub
		DepartmentReposatory.save(Departments);
	}

	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		DepartmentReposatory.deleteById(theId);
	}

}
