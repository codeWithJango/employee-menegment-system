package com.test.emplyeeSystem.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.emplyeeSystem.Exception.ResourceNotFoundException;
import com.test.emplyeeSystem.Model.Employee;
import com.test.emplyeeSystem.Repo.EmployeeInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class employeeService {

	@Autowired
	private EmployeeInterface employeeinterface;


	public List<Employee> getemployeelist() {
		SlowDBcall();
		
		return employeeinterface.findAll();

	}

	public Employee setemployee(Employee emp) {
		SlowDBcall();

		return employeeinterface.save(emp);
	}

	@Cacheable(value = "employee", key = "#id")
	public Employee getemployeebyid(int id) {
		SlowDBcall();
		return employeeinterface.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not updated with ID:" + id));
	}
	
	/**
	 * this method use to delay the Database call 
	 */
	private void SlowDBcall() {
		try {
			Thread.sleep(5000);
			
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

}
