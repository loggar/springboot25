package com.loggar.springboot25.repository.user;

import com.loggar.springboot25.model.user.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
