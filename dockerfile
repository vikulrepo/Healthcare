FROM openjdk:11
COPY target/*.jar app.jar
EXPOSE 8082
CMD ["java","-jar","app.jar"]
