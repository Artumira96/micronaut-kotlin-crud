## Micronaut & Kotlin CRUD
This project is a sample CRUD for a user (Id, Name, lastName, and age) implemented with Kotlin, Micronaut & postgres

command to start the project:
```shell 
./gradlew run
```

##allowed methods
GET

> http://localhost:8080/user/{id}

Expected Response:
```json
{
    "id": ##,
    "name": "XXX",
    "lastname": "YYY",
    "age": ##
}
```
POST
> http://localhost:8080/user/

sample request body:
```json
{ 
  "user":
  {
    "name":"Jhon", 
    "age":25, 
    "lastname":"Doe"
   }
}
```
Expected Response:
```json
{
    "id": ##,
    "name":"Jhon", 
    "age":25, 
    "lastname":"Doe"
}
```
PATCH
> http://localhost:8080/user/{id}

sample request body:
```json
{ 
  "user":
  {
    "age":30, 
    "lastname":"Perez"
   }
}
```
Expected Response:
``` json
{
    "id": ##,
    "name": "Jhon",
    ""age":30, 
    "lastname":"Perez"
}
```
DELETE
>http://localhost:8080/user/{id}

expected response:
`None`


##Perequirements
### DB

In order to run DB use the following command inside project folder:
```shell
docker-compose up
```
It is required to create DB that matches the ne defined here:
https://github.com/leo-licon/micronaut-kotlin-crud/blob/9f77a82990af016769dc777f69729edc791abd97/src/main/resources/application.yml#L7  