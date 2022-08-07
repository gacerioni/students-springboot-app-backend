FROM amazoncorretto:17

LABEL maintainer="Gabriel Cerioni <gacerioni@gmail.com>"

WORKDIR /

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

COPY ./target/*.jar /app.jar

EXPOSE 8080

CMD ["java", "-javaagent:/path/to/the/dd-java-agent.jar", "-jar", "/app.jar"]
