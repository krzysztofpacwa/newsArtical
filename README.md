# newsArtical
## General
Application for downloading articles from Poland from a [remote API](https://newsapi.org/docs/get-started).
User can display all and edit each of them.

## Endpoints
    http://localhost:8080/index
    http://localhost:8080/getArticle
    http://localhost:8080/updateArticle

## Configuration

application.properties file:
    
    api-token=    
    spring.datasource.url=
    spring.datasource.username=
    spring.datasource.password=
    spring.datasource.driver-class-name=


## Technologies
- Java 11
- Maven
- Spring Boot 2.4.0
- Thymeleaf
- Bootstrap(CSS)
- JQuery/JavaScript
- MySQL (remotesql.com)

**Design patterns**
- Model-view-controller (MVC)
- Data Access Object (DAO)
