# multiplication-comp-app

<p align="justify">
This application build with Java with Spring Framework and implementing Microservices Architecture with Agile methodology on development process. Application make users can triain their math skills every day. Every score that user had can calculation on rank boardgame every time.
</p>

## User Stories

### User Story 1
<p align="justify">
As a user of the application, I want to be presented with random multiplication that I can solve online not too easy, so I can use mental calculation and make my brain work every day.
</p>

* Sub Tasks :
    * Create a basic  service with the bussines logic,
    * Create a basic API endpoint to access this service (REST API),
    * Create a basic web page to ask the users to solve that calculation.

* Bussiness Objects :
    * Multiplication: contains the factors of the operation,
    * User: identifies the user who will try to solve a multiplication,
    * MultiplicationResultAttempt: contains a reference to the multiplication and a reference to the user.
    
* Rest API :
    * GET /multiplications/random : will return the random multiplication.
    * POST /results/ : will be our endpoint to send results.
    * GET /results?user=[user_alias] : will be our way od retrieving results of a pacticular user.

### User Story 2
<p align="justify">
As a user of the application, I want it to show me my last attempts, so I can see how good or bad I'm doing over time.
</p>



