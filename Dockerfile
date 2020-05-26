FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} my-novel-archive.jar
ENTRYPOINT ["java","-jar","/my-novel-archive.jar"]
