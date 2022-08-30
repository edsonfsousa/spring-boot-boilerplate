## Build stage
FROM maven:3.8.5-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -Dmaven.repo.local=/.m2 -f /home/app/pom.xml clean package -Dmaven.test.skip=true

## Package stage
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/spring-boot-boilerplate-0.0.1-SNAPSHOT.jar /run.jar

ENV DATASOURCE_JDBC="jdbc:postgresql://host.docker.internal:5432/boilerplate_db"
ENV DATASOURCE_USERNAME="postgres"
ENV DATASOURCE_PASSWORD="qwe123*"
# RUN apk add --no-cache tzdata
ENV TZ America/Fortaleza

WORKDIR /
ENTRYPOINT ["java","-jar", "run.jar"]
