FROM amazoncorretto:17

LABEL maintainer="Gabriel Cerioni <gacerioni@gmail.com>"

WORKDIR /

COPY ./target/*.jar /app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
