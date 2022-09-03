# multiplication-comp-app

<p align="justify">
This application build with Java with Spring Framework and implementing Microservices Architecture with Agile methodology on development process. Application make users can triain their math skills every day. Every score that user had can calculation on rank boardgame every time.
</p>

## CI/CD

| Service      | Status     |
| :------------ |   :---:       |
| MCA-CORE     | [![mca-core-ci](https://github.com/gusrylmubarok/multiplication-comp-app/actions/workflows/mca-core-ci.yml/badge.svg)](https://github.com/gusrylmubarok/multiplication-comp-app/actions/workflows/mca-core-ci.yml)    |
| *****     | *****    |

## User Stories

### User Story 1
<p align="justify">
As a user of the application,, I want to solve a random multiplication problem using mental calculation so I exercise my brain.
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

| HTTP Verb      | Operation on Collection, e.g /challenges     | Operation on Item, e.g /challenges/3     |
| :------------ |   :-----       | :-----     |
| GET     | Gets the full list of items     | Gets the item     |
| POST     | Creates a new item     | -     |
| PUT     | -     | Update the item     |
| DELETE     | Deletes the full collection     | Deletes the item     |

### User Story 2
<p align="justify">
As a user of the application, I want it to show me my last attempts, so I can see how good or bad I'm doing over time.
</p>



