FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8080
ADD target/devops-integration.jar devops-integration.jar
CMD ["java", "-jar", "devops-integration.jar"]
