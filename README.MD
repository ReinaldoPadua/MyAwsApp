# MyAwsAPP 1.0

### Requirements

Gradle 7.6, 
Java 17,
MYSQL 8,

### Usage
```
 gradle bootRun --args='--spring.profiles.active=local'
```
OR
```
docker-compose up   
```

### Using

* Swagger: http://localhost:8080/
* Metrics, health, prometheus:  http://localhost:8080/actuator 
* H2 Admin (local only): http://localhost:8080/h2-console/