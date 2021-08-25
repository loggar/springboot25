# NoClassDefFoundError for `JAXBException` in Java 9

Using `ms-jdk-11.0.11+9`

```
NoClassDefFoundError: javax/xml/bind/JAXBException
```

Solution:

```
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.0</version>
</dependency>
```
