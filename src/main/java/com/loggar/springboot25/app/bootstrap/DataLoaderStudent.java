package com.loggar.springboot25.app.bootstrap;

import com.loggar.springboot25.model.user.Student;
import com.loggar.springboot25.repository.user.StudentRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderStudent implements ApplicationListener<ContextRefreshedEvent> {
  private final StudentRepository repository;

  public DataLoaderStudent(StudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    Student student_a = new Student();
    student_a.setFirstName("Jane");
    student_a.setLastName("Doe");
    student_a.setYear("Junior");
    repository.save(student_a);

    Student student_b = new Student();
    student_b.setFirstName("Martin");
    student_b.setLastName("Fowler");
    student_b.setYear("Senior");
    repository.save(student_b);

    Student student_c = new Student();
    student_c.setFirstName("Roy");
    student_c.setLastName("Fielding");
    student_c.setYear("Freshman");
    repository.save(student_c);
  }
}
