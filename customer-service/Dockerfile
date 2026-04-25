FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/customer-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]