FROM openjdk:21-slim

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd curl && rm -rf /var/lib/apt/lists/*

COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

COPY target/account-0.0.1-SNAPSHOT.jar account.jar

EXPOSE 8081

ENTRYPOINT ["sh", "-c", "./wait-for-it.sh configserver 1010 -- ./wait-for-it.sh eurekaserver 8076 -- java -jar account.jar"]

