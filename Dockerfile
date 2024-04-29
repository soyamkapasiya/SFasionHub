FROM maven:3.8.5-openjdk-18 AS build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:18.0.1-jdk-sli
COPY --from=build /target/SFasionHub-0.0.1-SNAPSHOT.jar SFasionHub.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","SFasionHub.jar" ]
