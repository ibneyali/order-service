# order-service
The Order service, a backend microservice, will integrate with the Order-Application frontend service. This integration enables the Order service to retrieve order data from the frontend service, facilitating data exchange and enabling the backend to fulfill order-related functionalities.

1. Java 23
2. Spring Boot 3.4.1
3. MongoDB


Steps to build and run using docker-compose

1. mvn clean install
2. docker build -t ordermanagement .
3. docker-compose build
4. docker-compose up
