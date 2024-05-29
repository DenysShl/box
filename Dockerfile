FROM openjdk:17-alpine
LABEL authors="densh"
COPY target/pastebox-0.0.1-SNAPSHOT.jar /app/pastebox.jar
ENTRYPOINT ["java", "-jar", "/app/pastebox.jar"]