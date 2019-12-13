FROM openjdk:8
ADD target/vms-docker.jar vms-docker.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "vms-docker.jar"]