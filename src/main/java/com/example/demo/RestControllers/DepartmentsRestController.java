package com.example.demo.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Departments;
import com.example.demo.Entities.Employee;
import com.example.demo.Reposatories.EmployeeReposatory;
import com.example.demo.Service.DepartmentService;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping(value = "/Departments")
public class DepartmentsRestController {
	@Autowired
	DepartmentService DepartmentService;

	@Autowired
	com.example.demo.Reposatories.DepartmentReposatory DepartmentReposatory;

	@PutMapping("/SaveDepartment")
	public ResponseEntity<Departments> updateDepartments(@RequestBody Departments Departments) {
		try {

			return new ResponseEntity(DepartmentReposatory.save(Departments), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/SaveDepartment")
	public ResponseEntity<Departments> SaveDepartment(@RequestBody Departments Departments) {
		try {

			return new ResponseEntity(DepartmentReposatory.save(Departments), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/AllDepartments")
	public ResponseEntity<List<Employee>> AllDepartments() {
		try {
		//	List<Departments> allDepartments = DepartmentService.findAllDepartments();
			List<Page> allDepartments = DepartmentReposatory.AllDepartments();
			
			return new ResponseEntity(allDepartments, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/deleteDepartment")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Long id) {

		try {
			if (id != null) {
				DepartmentService.deleteById(id);

			}
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

}
