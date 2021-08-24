package com.loggar.springboot25.repository;

import com.loggar.springboot25.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
