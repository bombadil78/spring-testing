# Spring Testing Code Snippets

## General
Whenever Spring Boot testing features are added to work together with JUnit the *@RunWith(SpringRunner.class)* annotation is used.

## Testing JPA Repositories
The annotation *@DataJpaTest* does the following:
- Configuring H2 as in-memory database
- *DataSource*, Hibernate and Spring Data are set
- Scanning of entites
- SQL logging is turned on

Tests are annotated with 
```
@RunWith(SpringRunner.class)
@DataJpaTest
```

Then references to the repository under test and/or the underlying *EntityManager* is injected into the test using *@Autowired*

## References
- http://www.lucassaldanha.com/unit-and-integration-tests-in-spring-boot
- https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
- http://www.baeldung.com/spring-boot-testing
- http://www.baeldung.com/mockito-annotations