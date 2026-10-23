# --- Stage 1: Build Angular Frontend ---
FROM node:22-alpine AS frontend-builder
WORKDIR /app-frontend

# Install dependencies first (better caching)
COPY frontend/package*.json ./
RUN npm ci --ignore-scripts

# Copy source and build
COPY frontend/ .
# Adjust 'output-path' if needed in angular.json, or assume dist/project-name
RUN npm run build -- --configuration production

# --- Stage 2: Build Spring Boot Backend ---
FROM maven:3.9-eclipse-temurin-17 AS backend-builder
WORKDIR /app-backend

# Copy POM and install dependencies (caching layer)
COPY backend/pom.xml .
# Download dependencies without building to cache them
RUN mvn dependency:go-offline -B

# Copy backend source
COPY backend/src ./src

# CRITICAL STEP: Copy the compiled Angular files from Stage 1 into Spring Boot's static folder
# Note: Check your angular.json for the exact output path (e.g., dist/my-app)
COPY --from=frontend-builder /app-frontend/dist/frontend/browser ./src/main/resources/static/

# Build the JAR (skipping tests saves time on Pi)
RUN mvn clean package -DskipTests

# --- Stage 3: The Runtime Image ---
# We use a lightweight JRE for the final image
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built JAR from Stage 2
COPY --from=backend-builder /app-backend/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run it
ENTRYPOINT ["java", "-jar", "app.jar"]
