FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
EXPOSE 8080

COPY --from=build /app/target/devops-integration.jar devops-integration.jar

COPY --from=build /root/.m2/repository /app/.m2/repository

ENV CLASSPATH=/app/.m2/repository/*

# CMD to run the application
CMD ["java", "-jar", "devops-integration.jar"]
