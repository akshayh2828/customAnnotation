package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dro.Employee;

public interface ServiceInterface
{

	public List<Employee> getAllEmployee();
	public Employee createEmployee(Employee employee);
	public Optional<Employee> getEmployeeById(int id);
	public void deleteEmployeeById(int id);
	public Employee editEmployee(Employee employee,int id) throws Exception;
	
}
