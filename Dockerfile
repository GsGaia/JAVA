
FROM gradle:8.13-jdk17 AS builder

RUN apt-get update && apt-get install -y git

WORKDIR /app

RUN git clone https://github.com/GsGaia/JAVA.git .
RUN gradle clean build --no-daemon


FROM gradle:8.13-jdk21

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
