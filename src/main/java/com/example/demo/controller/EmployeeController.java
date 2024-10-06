package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.dro.Employee;
import com.example.demo.service.EmployeeServiceImplementation;

@RestController
@RequestMapping("/emp")
public class EmployeeController 
{
	@Autowired
	private EmployeeServiceImplementation emplyeeService;
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		Employee emp1=emplyeeService.createEmployee(emp);
		return new ResponseEntity<Employee>(emp1,HttpStatus.ACCEPTED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> emp=emplyeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable int id)
	{
		Employee emp=emplyeeService.getEmployeeById(id).get();
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable int id) throws Exception
	{

		try {
			emp.setEmpId(id);
			Employee emp1=emplyeeService.editEmployee(emp, id);
            return new ResponseEntity<>(emp1, HttpStatus.OK);


		} catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		}


	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id)
	{
		emplyeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	

}
