FROM openjdk:21-slim

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd && rm -rf /var/lib/apt/lists/*

COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver.jar

EXPOSE 8076

ENTRYPOINT ["./wait-for-it.sh", "configserver 1010", "--", "java", "-jar", "eurekaserver.jar"]
