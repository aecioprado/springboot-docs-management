# Stage 1: Build Stage
FROM eclipse-temurin:21-jdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle configuration files and Gradle wrapper scripts first
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .

# Download dependencies without building
RUN ./gradlew --no-daemon dependencies

# Copy the entire project
COPY . .

# Build the project
RUN ./gradlew clean build -x test

# Stage 2: Runtime Stage
FROM eclipse-temurin:21-jre-alpine AS runtime

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application's port (replace with your actual port if different)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
