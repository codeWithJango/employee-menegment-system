package com.test.emplyeeSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.emplyeeSystem.Model.Employee;


@Repository

public interface EmployeeInterface    extends JpaRepository<Employee, Integer>{

}
