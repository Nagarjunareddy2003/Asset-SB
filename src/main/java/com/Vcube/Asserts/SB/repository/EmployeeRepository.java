package com.Vcube.Asserts.SB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vcube.Asserts.SB.modal.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
