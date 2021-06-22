FROM openjdk:8-jre-alpine
COPY . /usr/src
WORKDIR /usr/src
CMD ["/bin/sh", "-c", "java -jar -Dserver.port=8080 mongo-homework.jar"]