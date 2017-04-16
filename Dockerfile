FROM openjdk:8
EXPOSE 8080
ADD ./target/TestSpreadsheet-0.0.1-SNAPSHOT.war testDocker.war
ENTRYPOINT ["java","-jar","testDocker.war"]

