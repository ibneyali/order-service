# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "ordermanagement.jar"]