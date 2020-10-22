FROM openjdk:8
LABEL name="socketDemo" version="1.0" author="Cloud Yang"
COPY target/Echart-and-Websocket-1.0-SNAPSHOT.jar /Runnable.jar
CMD ["java", "-jar", "Runnable.jar"]