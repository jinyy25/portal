FROM openjdk:8-jdk-alpine

# Set the working directory
#WORKDIR /app

EXPOSE 8081
ADD ./build/libs/Portal-1.0.0.jar portal.jar
ENTRYPOINT ["java","-jar","portal.jar"]

