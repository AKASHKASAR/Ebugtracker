FROM openjdk:8-jdk-alpine
EXPOSE 9090
COPY target/ebugtracker-casestudy-0.0.1-SNAPSHOT.jar ebugtracker-casestudy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ebugtracker-casestudy-0.0.1-SNAPSHOT.jar"]

