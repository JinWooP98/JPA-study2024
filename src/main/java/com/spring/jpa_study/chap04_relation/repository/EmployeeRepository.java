package com.spring.jpa_study.chap04_relation.repository;

import com.spring.jpa_study.chap04_relation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
