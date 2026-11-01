package com.test.emplyeeSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.emplyeeSystem.Model.Employee;
import com.test.emplyeeSystem.Repo.EmployeeInterface;
import com.test.emplyeeSystem.Service.employeeService;

@CrossOrigin(
	    origins = "http://localhost:4200",
	    allowedHeaders = "*",
	    methods = {
	        RequestMethod.GET,
	        RequestMethod.POST,
	        RequestMethod.OPTIONS
	    }
	)

@RestController
public class Employeecontroller {
@Autowired
private employeeService empservice;
	
	
	@GetMapping("/employee")
	public List<Employee>getEmployeelist(){
		
		List<Employee> empdata= empservice.getemployeelist();
		return empdata;
		
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee){
		return  empservice.setemployee(employee);
		
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee>getEmployeeByID( @PathVariable int id){
		
		Employee employee  = empservice.getemployeebyid(id);
	
	return  ResponseEntity.ok(employee);
		
	}
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee>updateEmployeeDetails(@PathVariable int id, @RequestBody Employee empdetails){
		Employee employee  = empservice.getemployeebyid(id);
		System.out.println("Chek_employee=======>"+employee);
		
		if(employee.getId()==id) {
		
	employee.setFirstname(empdetails.getFirstname());
	System.out.println("Firstname---->"+empdetails.getFirstname());
	employee.setLastname(empdetails.getLastname());
	System.out.println("Lastname---->"+empdetails.getLastname());
	employee.setSalary(empdetails.getSalary());
	System.out.println("salary---->"+empdetails.getSalary());
	Employee employeedata=   empservice.setemployee(employee);
	System.out.println("employeedata_visible===========>"+employeedata);
	return ResponseEntity.ok(employee);
	
	}
		else {
			return null;
		}
	}

	
	
}
