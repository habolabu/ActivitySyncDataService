FROM gradle:jdk17-alpine
WORKDIR /activity-sync-service

COPY src /activity-sync-service/src/
COPY build.gradle .
COPY lombok.config .

RUN gradle clean build -x test

ENTRYPOINT ["java", "-jar", "./build/libs/activity-sync-service-1.0.0.jar"]