# Number Classification APP

The Number Classification APP is a Spring Boot application that classifies given numbers based on different properties, such as prime, perfect, Armstrong, and odd/even. It also uses an external API to fetch fun, unique facts about numbers.

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

#### To classify a Number locally, use:

```bash
GET http://localhost:8080/api/classify-number?number=371
```
#### Example Response:
```bash
{
    "number": 371,
    "is_prime": false,
    "is_perfect": false,
    "properties": ["armstrong","odd"],
    "digit_sum": 11,
    "fun_fact": "371 is a narcissistic number."
}
```


### Handling Invalid Input
```bash
GET http://localhost:8080/api/classify-number?number=alphabet
```
#### Example Response:
```bash
{
    "number": "alphabet",
    "error": true
}
```

## Deployment
This API is deployed on Railway. You can classify any number using the following URL:
```bash{
    https://numbersclassificationapp-production.up.railway.app/api/classify-number?number={your_number}
```
**Example**:

[https://numbersclassificationapp-production.up.railway.app/api/classify-number?number=371](https://numbersclassificationapp-production.up.railway.app/api/classify-number?number=371)


### Running tests
To execute unit test, run:
```bash
    mvn test
```

