package com.example.demo.dro;

import com.example.demo.validation.ValidateEmployeeType;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name="emp")
public class Employee 
{
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private int empId;
	    @NotBlank(message = "firstName shouldn't be null or empty")
	    private String firstName;
	    @NotBlank(message = "lastName shouldn't be null or empty")
	    private String lastName;
	    @Past(message = "start shouldn't be before current date")
	    @JsonFormat(pattern = "dd-MM-yyyy")
	    private Date doj;
	    @NotNull(message = "department shouldn't be null")
	    @NotEmpty(message = "department shouldn't be empty")
	    private String dept;
	    @Email(message = "invalid email id")
	    private String email;

	    //custom annotation
	    @ValidateEmployeeType
	    private String employeeType; //permanent or vendor or contractual

		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(int empId, @NotBlank(message = "firstName shouldn't be null or empty") String firstName,
				@NotBlank(message = "lastName shouldn't be null or empty") String lastName,
				@Past(message = "start shouldn't be before current date") Date doj,
				@NotNull(message = "department shouldn't be null") @NotEmpty(message = "department shouldn't be empty") String dept,
				@Email(message = "invalid email id") String email, String employeeType) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.doj = doj;
			this.dept = dept;
			this.email = email;
			this.employeeType = employeeType;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDoj() {
			return doj;
		}

		public void setDoj(Date doj) {
			this.doj = doj;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEmployeeType() {
			return employeeType;
		}

		public void setEmployeeType(String employeeType) {
			this.employeeType = employeeType;
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", doj=" + doj
					+ ", dept=" + dept + ", email=" + email + ", employeeType=" + employeeType + "]";
		}
	    
	    
	    
		
	    
}
