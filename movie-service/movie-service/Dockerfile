FROM openjdk:8
ADD target/movie-service.jar movie-service.jar
EXPOSE 9203
ENTRYPOINT ["java", "-jar", "movie-service.jar"]