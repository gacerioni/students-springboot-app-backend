FROM amazoncorretto:17

LABEL maintainer="Gabriel Cerioni <gacerioni@gmail.com>"

WORKDIR /

RUN curl -L -o dd-java-agent.jar https://dtdg.co/latest-java-tracer
RUN chmod 777 dd-java-agent.jar

COPY ./target/*.jar /app.jar

EXPOSE 8080

CMD ["java", "-javaagent:/dd-java-agent.jar", "-jar", "/app.jar"]
