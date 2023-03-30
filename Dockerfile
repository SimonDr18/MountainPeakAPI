FROM eclipse-temurin:17

ADD target/mountain-peak-api-docker.jar mountain-peak-api-docker.jar
ENTRYPOINT ["java", "-jar", "mountain-peak-api-docker.jar"]
EXPOSE 8080
