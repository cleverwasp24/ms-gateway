FROM openjdk:17-oracle
ADD target/ms-gateway-0.0.1-SNAPSHOT.jar ms-gateway.jar
ENTRYPOINT ["java","-jar","ms-gateway.jar"]