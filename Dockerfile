FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/libs/homepage-0.0.1-SNAPSHOT.jar likelion-homepage.jar
ENTRYPOINT ["java", "-jar", "likelion-homepage.jar"]