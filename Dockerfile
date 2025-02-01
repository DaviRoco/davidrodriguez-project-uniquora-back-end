# Use OpenJDK 17 slim as base image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the JAR file from the build directory into the container
COPY build/libs/uniquora-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

ENV SPRING_APPLICATION_NAME=uniquora \
    SPRING_DATASOURCE_URL=${DEV_SPRING_DATASOURCE_URL} \
    SPRING_DATASOURCE_USERNAME=${DEV_SPRING_DATASOURCE_USERNAME} \
    SPRING_DATASOURCE_PASSWORD=${DEV_SPRING_DATASOURCE_PASSWORD} \
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
