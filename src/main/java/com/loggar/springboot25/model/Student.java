package com.loggar.springboot25.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Annotations:
// @Entity – This class-level annotation specifies that this Java class should be persisted to a database table.
// @Id – This field-level annotation specifies the primary key of the entity and maps it to the primary key of the table. 
// @GeneratedValue – This annotation specifies how the primary key ID will be generated.  In our example, we chose GenerationType.AUTO meaning that the JPA provider (Hibernate) will decide which strategy to employ based on the database dialect used. 

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;

  private String lastName;

  private String year;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
