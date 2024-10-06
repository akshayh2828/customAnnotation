package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dro.Employee;
import com.example.demo.repo.EmployeeRepo;
@Service
public class EmployeeServiceImplementation implements ServiceInterface
{
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		
		return empRepo.findById(id);
	}

	@Override
	public void deleteEmployeeById(int id) 
	{
		empRepo.deleteById(id);
		
	}

	@Override
	public Employee editEmployee(Employee employee,int id) throws Exception 
	{
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent())
		{
            Employee existingEmployee = emp.get();
            existingEmployee.setDept(employee.getDept());
            existingEmployee.setDoj(employee.getDoj());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setEmpId(employee.getEmpId());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmployeeType(employee.getEmployeeType());
            return empRepo.save(employee);

		}
		else
		{
			throw new Exception("id is not found"+id);
		}
	
	}

}
