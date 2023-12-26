FROM openjdk:latest

COPY src/main/ /app

WORKDIR /app

CMD ["java", "-jar", "java.jar"]
