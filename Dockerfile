# Use Java 17
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy the jar built by Maven
COPY target/fancy-calculator-1.0.0.jar app.jar

# Our app listens on 8080
EXPOSE 8080

# Start the app
ENTRYPOINT ["java","-jar","app.jar"]
