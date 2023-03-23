FROM openjdk:17-alpine

MAINTAINER ITAcademy

COPY ./target/*.jar app.jar

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app.jar"]

EXPOSE 8080 8089
