# Use a base image with Java 17
FROM openjdk:17-jdk-slim as build
WORKDIR /workspace/app

# Copy the Maven wrapper and project definition files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Package the application
RUN ./mvnw install -DskipTests

FROM openjdk:17-jre-slim
VOLUME /tmp
# Copy the JAR from the build stage
COPY --from=build /workspace/app/target/bm-teams-*.jar bm-teams.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bm-teams.jar"]
