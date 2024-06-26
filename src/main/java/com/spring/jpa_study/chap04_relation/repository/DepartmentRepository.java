package com.spring.jpa_study.chap04_relation.repository;

import com.spring.jpa_study.chap04_relation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {



}
