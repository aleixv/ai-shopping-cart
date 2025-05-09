FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build.gradle settings.gradle gradle.properties gradlew gradlew.bat ./
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew bootJar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/ai-shopping-cart-0.0.1-SNAPSHOT.jar"]