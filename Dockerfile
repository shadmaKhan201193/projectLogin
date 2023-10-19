FROM openjdk:17-jdk-slim
COPY /build/libs/loginservice-0.0.1.jar usr/src/loginservice-0.0.1.jar
EXPOSE 8183
CMD ["java","-jar","usr/src/loginservice-0.0.1.jar"]
