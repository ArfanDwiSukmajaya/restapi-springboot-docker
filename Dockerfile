FROM openjdk:18.0-slim

COPY target/Backend-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]