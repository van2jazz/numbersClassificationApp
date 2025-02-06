# Number Classification API

The Number Classification API is a Spring Boot application that classifies numbers based on various properties, such as prime, perfect, Armstrong, and odd/even. It also fetches fun facts about numbers using an external API.

### Features

+ Check if a number is prime or perfect.
+ Identify special properties like Armstrong numbers.
+ Compute the sum of digits.
+ Fetch a fun fact from an external API.
+ Handle invalid input (e.g., alphabetical values).
  
### Technologies Used

+ Java
+ Maven 
+ Spring Boot
+ Mockito & JUnit 5 – For unit testing
+ Lombok – To reduce boilerplate code
+ Railway (for deployment)



  
## Setup Instruction

To clone this repository

```bash
git clone https://github.com/van2jazz/numbersClassificationApp
```

Build the Application:

```bash
mvn clean install
```

Build the Application:

```bash
mvn spring-boot:run
```


## API Endpoints
#### Classify a Number

```bash
GET /classify/{number}
```







Access the API Locally at:


## API Documentation

### Endpoint URL
```bash
GET /api
```

### Response Format(200 OK)

    {
      "email": "van2jazz@gmail.com",
      "current_datetime": "2025-01-30T22:29:19Z",
      "github_url": "https://github.com/van2jazz/hng"
    }


## Deployment

This API is deployed on Railway. You can access it at:

[https://hng-production-1736.up.railway.app/api](https://hng-production-1736.up.railway.app/api)


## Related Links
[Hire Java developers](https://hng.tech/hire/java-developers)
