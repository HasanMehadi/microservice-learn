FROM openjdk:21-slim

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd curl && rm -rf /var/lib/apt/lists/*

COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

COPY target/gatewayserver-0.0.1-SNAPSHOT.jar gatewayserver.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "./wait-for-it.sh configserver 1010 -- ./wait-for-it.sh eurekaserver 8076 -- ./wait-for-it.sh account 8081 -- ./wait-for-it.sh loan 9091 -- ./wait-for-it.sh card 7071 -- java -jar gatewayserver.jar"]

