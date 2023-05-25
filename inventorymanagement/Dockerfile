FROM amazoncorretto:17

WORKDIR /app

COPY build/libs/* /app

EXPOSE 8092
EXPOSE 8095

CMD ["java", "-jar", "inventorymanagement-0.0.1-SNAPSHOT.jar"]