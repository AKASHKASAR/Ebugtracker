FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/ebugtracker-casestudy-0.0.1-SNAPSHOT.jar ebugtracker-casestudy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ebugtracker-casestudy-0.0.1-SNAPSHOT.jar"]

