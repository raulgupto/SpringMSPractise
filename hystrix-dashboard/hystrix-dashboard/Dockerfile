FROM openjdk:8
ADD target/hystrix-dashboard.jar hystrix-dashboard.jar
EXPOSE 9295
ENTRYPOINT ["java", "-jar", "hystrix-dashboard.jar"]