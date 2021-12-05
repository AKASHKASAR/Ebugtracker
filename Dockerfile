FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/ebugtracker-casestudy.jar ebugtracker-casestudy.jar
ENTRYPOINT ["java","-jar","/ebugtracker-casestudy.jar"]

