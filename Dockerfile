FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/todo.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-war", "app.war"]
