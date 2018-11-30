#Exemple-of-dockerfileCreating
FROM openjdk:8
ADD target/docker-bank-management.jar docker-bank-management.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-bank-management.jar"]

#sudo docker build -f Dockerfile -t docker-bank-management .
#sudo docker images
#sudo docker run -p 8085:8085 docker-bank-management
