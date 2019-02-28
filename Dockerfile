# Using Java 8
FROM java:8
# copy JAR into image
ADD target/airlineinfo-0.0.1.jar airlineinfo-0.0.1.jar
# run application with this command line 
ENTRYPOINT [ "/bin/sh", "-c", "java -jar airlineinfo-0.0.1.jar --server.port=9090" ]