# Imagem de runtime leve com Java 21
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia apenas o JAR gerado pelo build local
COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]


CMD ["java", "-jar", "app.jar"]
