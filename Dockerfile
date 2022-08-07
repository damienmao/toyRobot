FROM openjdk:13-jdk-alpine3.10
RUN mkdir /home/app
COPY ./target/toy-1.0-SNAPSHOT.jar /home/app
CMD ["java","-jar","/home/app/toy-1.0-SNAPSHOT.jar"]
