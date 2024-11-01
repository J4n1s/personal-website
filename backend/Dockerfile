# Use a base image with JDK 22
FROM openjdk:22

# Set the working directory
WORKDIR /app

# Copy the JAR file created by Maven to the container
COPY target/backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
