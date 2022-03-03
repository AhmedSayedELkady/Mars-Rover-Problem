## Steps to run the application

1. mvn clean package (build the service with maven). 

2. java -jar target/Mars-Rover-Problem-0.0.1-SNAPSHOT.jar (run the project with java)

3. To test :

   - I had tested API through http://localhost:8080/v1/api?move=FLFFFRFLB using initial coordinates for x= 4 , y= 2 , direction ="EAST" and commands "FLFFFRFLB"

     and output : {"position":{"x":6,"y":4},"direction":"NORTH","status":"FINSHED"}.

   - you can test any command by changing value of move in URL .