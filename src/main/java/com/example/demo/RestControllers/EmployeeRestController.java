package com.example.demo.RestControllers;

import java.util.ArrayList;
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

import com.example.demo.Entities.Employee;
import com.example.demo.Reposatories.EmployeeReposatory;
import com.example.demo.Service.EmployeeService;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@RestController
@RequestMapping(value = "/Employees")
public class EmployeeRestController {
	@Autowired
	EmployeeService EmployeeService;

	@Autowired
	EmployeeReposatory EmployeeReposatory;

	@PutMapping("/UpdateEmployee")
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee Employee) {
		try {

			return new ResponseEntity(EmployeeReposatory.save(Employee), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/SaveEmployee")
	public ResponseEntity<Employee> SaveEmployee(@RequestBody Employee Employee) {
		try {
			if ((Employee.getFirst_name() != null && Employee.getFirst_name().length() < 2)
					|| (Employee.getLast_name() != null && Employee.getLast_name().length() < 2)
					|| (Employee.getSalary() != null && Employee.getSalary() < 0)) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity(EmployeeReposatory.save(Employee), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/DeleteEmployee/{id}")
	public ResponseEntity<HttpStatus> DeleteEmployee(@PathVariable Long id) {
		try {
			if (id != null) {
				EmployeeService.deleteById(id);

			}
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/AllEmployees")
	public ResponseEntity<List<Employee>> AllEmployees() {
		try {
			// List<Employee> AllEmployees = EmployeeService.findAllEmployees();

			List<Page> AllEmployees = EmployeeReposatory.AllEmployees();

			return new ResponseEntity(AllEmployees, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}
}
