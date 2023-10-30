FROM maven:3.9.4-amazoncorretto-21 as build
MAINTAINER intertec.io
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/testapp-0.0.1-SNAPSHOT.jar"]