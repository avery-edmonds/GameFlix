FROM openjdk:17.0.2-jdk-slim-bullseye

VOLUME /tmp

ARG JAR_FILE=target/GameFlix-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Make Spring Boot listen on all interfaces
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE=default

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]