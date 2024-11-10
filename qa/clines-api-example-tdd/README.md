# Clines API

Clines API is the backend of **Caelum Aero linhas**. It allows the customer to buy flight reservations and 
backoffice user to management flights, airport and aircraft.


## Prerequisites
Before you begin, ensure you have met the following requirements:

* Java 11 
* Docker 19+
* Docker Compose 1.25+
* GNU Make 3.8+ 

## Running Clines API

To run this project simply execute this commands inside de project path

```shell script
./mvnw clean package
docker image build --build-arg JAR=target/clines-api-0.0.1-SNAPSHOT.jar -t caelum/clines-api:latest .
docker-compose up
```
