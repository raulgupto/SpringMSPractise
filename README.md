# SpringMS Practise

Practice Project with these Simple springboot applications working as individual services imitating small microservice architecture.

- User Service
- Movie Service
- Department Service
    
*Uses H2 as database and Hibernate for persistence, Movie service has paged results as well as non paged results exposed.
Communicate with each other using REST and documented with **Swagger***
 
- Service Registry => Uses Spring Eureka Server and acts as Eureka Server
 
- API Gateway -> *Spring cloud gateway -> Routes external requests to different services (Configuration done in application.yml)
					and has  circuit breaker implemented with timeout and fallback uri calling get methods for some services.*
- Hystrix Dashboard -> Has stream enabled and displays metrics in Dashboard
- Cloud Config -> Config Server :  uses git repository as cenral config server, config is enabled in all services and bootstrap.yml loads config properties.