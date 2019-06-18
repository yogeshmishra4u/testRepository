FROM java:8

EXPOSE 5000:5000

ADD target/greeting-rest-api.jar greeting-rest-api.jar

ENTRYPOINT ["java","-jar","greeting-rest-api.jar"]