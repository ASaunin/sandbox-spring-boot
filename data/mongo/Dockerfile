FROM java:8-jdk-alpine
VOLUME /tmp
ADD target/mongo-1.0.0-SNAPSHOT.jar spring-boot-docker.jar
RUN sh -c 'touch /spring-boot-docker.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-docker.jar"]