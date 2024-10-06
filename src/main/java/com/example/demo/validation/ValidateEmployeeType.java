package com.example.demo.validation;

import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {

    public String message() default "Invalid employeeType: It should be either Permanent Or vendor";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
