FROM java:8
EXPOSE 8080
COPY /target/tis-service.jar tis-service.jar
ENTRYPOINT ["java","-jar","tis-service.jar"]