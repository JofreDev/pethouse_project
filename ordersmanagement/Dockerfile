FROM amazoncorretto:17

WORKDIR /app

COPY build/libs/* /app

EXPOSE 8085
EXPOSE 80

CMD ["java", "-jar", "ordersmanagement-0.0.1-SNAPSHOT.jar"]