# Java-Game-Store-Project

#Gradle-Groovy Project
#Java
#Spring Boot version 3.0.2
#Spring Boot Dependencies:
    Spring Web
    Spring Data JPA
    MySQL Driver
#MySQL Database
#Database managed using XAMPP
#Database named "gamestore"
Test Done with PostMan
#Project allow managament of Games, Reviews for said games and User

Using a Database with the help of XAMPP
simply running DemoApplication should allow the use of the Project using PostMan or any equivalent API platform

#Games 
"CREATE TABLE `games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categories` varchar(255) DEFAULT NULL,
  `developer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)"
#Endpoints for Games
    "localhost:8080/store"
    #Both GET and POST use this endpoints
    Sending a GET request in PostMan with the path above
    returns all currently registered games on the database
   
   #POST requires a JSON payload as the one below
    {
    "name" : "Game Name",
    "categories" : "Game Categories",
    "developer" : "Game Developer",
    "publisher" : "Game Publisher",
    "price" : 60.0
    }
    
    "localhost:8080/store/update/{gameId}"
    #PUT uses this path, in {gameId}'s place should be the id of game you want to update,
      it needs a JSON payload with the attributes you want to update, like this:
      {
      "name" : "Game Name",
      "categories" : "Game Categories",
      "developer" : "Game Developer",
      "publisher" : "Game Publisher",
      "price" : 60.0
      }
      
    "localhost:8080/store/{gameId}"
      #DELETE uses this path, in {gameId}'s place should be the id of game you want to delete

#Users
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
#Endpoints for Users
    "localhost:8080/users"
    #Both GET and POST use this endpoints
    Sending a GET request in PostMan with the path above
    returns all currently registered users on the database
   
   #POST requires a JSON payload as the one below
    {
    "name":"user name",
    "surname":"user surname"
    }
    
    "localhost:8080/store/update/{userId}"
    #PUT uses this path, in {userId}'s place should be the id of user you want to update,
      it needs a JSON payload with the attributes you want to update, like this:
      {
      "name":"user name",
      "surname":"user surname"
      }
      
    "localhost:8080/store/{userId}"
      #DELETE uses this path, in {userId}'s place should be the id of user you want to delete

#Reviews    
 CREATE TABLE `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_REVIEWS_ON_GAME` (`game_id`),
  KEY `FK_REVIEWS_ON_USER` (`user_id`),
  CONSTRAINT `FK_REVIEWS_ON_GAME` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`),
  CONSTRAINT `FK_REVIEWS_ON_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)   

#Endpoints for Reviews
    "localhost:8080/reviews/{gameId}"
    #POST requires a JSON payload as the one below, uses the path above, in {gameId}'s place should be the id of game you want to review 
    {
    "text" : "Text",
    "rating" : 10,
    "userId": 1
    }
    
