FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /shop
COPY . .
RUN mvn -f /shop/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /shop
COPY --from=builder /shop/target/*.jar /shop/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]