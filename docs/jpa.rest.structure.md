# jpa with springboot

dependencies

```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
      <version>${springboot.version}</version>
    </dependency>
    <!-- Jakarta XML Binding -->
    <!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
    <dependency>
      <groupId>javax.xml.bind</groupId>
      <artifactId>jaxb-api</artifactId>
      <version>2.3.1</version>
    </dependency>
    <!-- mysql -->
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>
</dependencies>
```

datasource

`application.properties`

```ini
## datasource
spring.datasource.url=jdbc:mysql://localhost:3306/jpa_example
spring.datasource.username=jpa_user
spring.datasource.password=mypassword

## jpa
## The spring.jpa.hibernate.ddl-auto property is used to initialize the database. The create-drop option will create any tables mapped to JPA entities during application startup and drop the tables at shutdown.
spring.jpa.hibernate.ddl-auto=create-drop
## The spring.jpa.show-sql property is set to true to display the SQL statements in the console or log file.
spring.jpa.show-sql=true
```

- model `com.loggar.springboot25.model.Student`
- repository component `com.loggar.springboot25.repository.StudentRepository`
- service component (omitted)
- rest controller `com.loggar.springboot25.controller.student.StudentController`
- test http requests (REST Client) `src/test/http/rest/model/student.http`
