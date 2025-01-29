# apichallenge
API challenge for greeting cards

# Build the project:
mvn clean install

# Run the project:
mvn spring-boot:run

# Check the application healthiness, if it's UP and running:
localhost:8081/actuator/health

# Access the application from browser or postman:
localhost:8081/v1/cards

# The data from third party API:
# Get a random joke:
localhost:8081/v1/random-joke

# Check the swagger documentation:


![Barney](https://cloud.githubusercontent.com/assets/3603793/23482593/669e9444-feae-11e6-9b6b-d1a53faf984a.png)

# Thortful API Challenge


Show us what you can do with Spring Boot! 

We'd like you to write a small app with the following requirements:

* Restful API  
* Use of any 3rd party API services
* Version of Java you like the most
* Readme file explaining how to build / run your app.

On the 3rd party API side, the choice is yours, from the Star wars API (https://swapi.co), Github(https://developer.github.com/v3/search/#search-issues), (Random User API (https://randomuser.me), .....

Few notes on the app:

* UI : None, as long as we can call your endpoints with Postman or curl, we're happy 
* Documentation : README file doesn't have to be long but please help us getting your app in a running state
* Code : We like code, we like it even more when it's clearly written ;)

We could be sneaky and not say anything else, but here's some things we always like to see:

* Use of cool APIs we never heard about
* Not having a 500 error on the first boot
* Not having all your app code in one giant method
* More than one commit in git

### Submission notes

You can just submit a PR here, create a private repo, or just send us the repo by email. Whatever you prefer.

---

[@thortful](https://wwwthortful.com) - 2018
