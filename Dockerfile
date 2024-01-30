FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
EXPOSE 8080

COPY --from=build /app/target/devops-integration.jar devops-integration.jar

# CMD to run the application
CMD ["java", "-jar", "devops-integration.jar"]
