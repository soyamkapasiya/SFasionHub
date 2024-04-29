FROM maven:3.8.5-openjdk-18 AS build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:18.0.1-jdk-slim
COPY target/*.jar SFasionHub.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","SFasionHub.jar" ]
