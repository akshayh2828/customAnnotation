package com.example.demo.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeTypeValidator implements ConstraintValidator<ValidateEmployeeType, String>
{

	@Override
	public boolean isValid(String employeeType, ConstraintValidatorContext context) {
        List<String> employeeTypes = Arrays.asList("Permanent", "vendor");

        return employeeTypes.contains(employeeType);

	}

	
}
