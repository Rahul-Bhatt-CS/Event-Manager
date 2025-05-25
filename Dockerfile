# Use Eclipse Temurin Java 21 JDK base image
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from target/ folder to container as app.jar
COPY target/*.jar app.jar

# Expose port 8080 (standard Spring Boot port)
EXPOSE 8080

# Run the Spring Boot app, telling it to listen on the port Render provides via $PORT env variable
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
