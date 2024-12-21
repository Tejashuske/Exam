FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY Add.java /app/
RUN javac Add.java
CMD ["java", "Add"]