FROM openjdk:11-jdk-alpine
VOLUME /tmp

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/ebugtracker-casestudy.jar"]

