# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk

# Expose port 1212 to the outside world
EXPOSE 1212

# Add the application's jar to the container
ADD target/ordermanagement.jar ordermanagement.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/ordermanagement.jar"]