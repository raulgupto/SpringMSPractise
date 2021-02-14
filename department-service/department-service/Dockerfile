FROM openjdk:8
ADD target/department-service.jar department-service.jar
EXPOSE 9200
ENTRYPOINT ["java", "-jar", "department-service.jar"]