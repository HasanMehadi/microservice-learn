FROM openjdk:21-slim

WORKDIR /app

COPY target/configserver-0.0.1-SNAPSHOT.jar configserver.jar

EXPOSE 1010

ENTRYPOINT ["java", "-jar", "configserver.jar"]
