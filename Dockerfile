FROM maven:3.9.4-amazoncorretto-21 as build
MAINTAINER intertec.io
ADD https://github.com/martindimoski/hoc_qa_testapp/tree/main/src/. /home/app/src
ADD https://raw.githubusercontent.com/martindimoski/hoc_qa_testapp/main/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/testapp-0.0.1-SNAPSHOT.jar"]