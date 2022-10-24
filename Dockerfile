FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-gateway.jar
ENTRYPOINT ["java","-jar","/ms-gateway.jar"]