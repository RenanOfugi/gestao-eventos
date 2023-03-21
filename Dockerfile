FROM maven:3.8.3-openjdk-17 AS builder
FROM tomcat:9.0.58-jdk17-openjdk-slim

WORKDIR /app

COPY . .

#RUN ls
#RUN mvn -f /pom.xml clean package -DskipTests -DoutputDirectory=target 

#RUN ls -lah /usr/src/mvn/target
 
COPY target/gestaoeventos-0.0.1-SNAPSHOT.jar /app/gestaoeventos.jar
EXPOSE 1111
#ADD target/gestaoeventos-0.0.1-SNAPSHOT.jar gestaoeventos.jar

ENTRYPOINT ["java", "-jar","gestaoeventos.jar"]

