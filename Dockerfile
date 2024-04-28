FROM openjdk:17.0

COPY build/libs/demo-0.0.1-SNAPSHOT.jar aplicacion.jar

ENTRYPOINT ["java", "-jar", "/aplicacion.jar"]
