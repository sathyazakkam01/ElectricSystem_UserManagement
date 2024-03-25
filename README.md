# User Register API for Electric System

## Overview

This project implements a RESTful API for managing user registrations in a new electric system. It supports operations to retrieve, add ,update and delete user information based on id and also retrieve an based on the surname.

## Features

- Retrieve users by surname.
- Add new users.
- Retrieve, Add, Delete and Update user information based on Id.

## Technical Stack

- **Framework**: Spring Boot (Java)
- **Database**: H2 in-memory
- **Build Tool**: Gradle

## Prerequisites

- Java JDK 11 or higher
- Gradle
- An IDE like IntelliJ IDEA, Eclipse, or VS Code

## Setting Up and Running

1. **Clone the Repository**
```bash
  git clone https://github.com/sathyazakkam01/ElectricSystems.git 
   ```
## Build the Application

2. **To build the application using Gradle, execute the following command in your terminal**

```bash
./gradlew build
```

## Run the Application

3. **Start the application with the following command**

```bash
./gradlew bootRun
```

The application will then be accessible at `http://localhost:8080`.

## Accessing the H2 Database Console

4. **You can access the H2 Database Console using the steps below:**

   1. Open a web browser and navigate to `http://localhost:8080/h2-console`.
   2. Use the following credentials and settings to log in:
      - JDBC URL: `jdbc:h2:mem:testdb`
      - User Name: `sa`
      - Password: (leave this field blank)

## API Endpoints

### Retrieve Users by Surname

To retrieve users by their surname, issue a GET request to:

```plaintext
GET http://localhost:8080/api/users?surname=Zakkam
```

### Add User

To add a new user to the system, issue a POST request to:

```plaintext
POST http://localhost:8080/api/users
Content-Type: application/json

{
    "surname": "Zakkam",
    "firstName": "Sathya",
    "email": "sathya.zakkam@example.com"
}
```

## Testing

Run the unit tests by executing the following command:

```bash
./gradlew test
```

## Conclusion

This README guides you through setting up, running, and testing the User Register API. It demonstrates the basic features of a RESTful service using Spring Boot and an H2 in-memory database.

