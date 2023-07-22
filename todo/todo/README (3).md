# ToDoApp


## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Model](#model)
- [Contributing](#contributing)


## Introduction

ToDoApp is a web-based application designed to manage todo tasks. It allows users to create, update, and track their tasks, whether they are completed or not.

## Features

- View a list of all todo tasks.
- View details of a specific todo task by its ID.
- Create a new todo task.
- Update an existing todo task's details.
- Mark a todo task as completed (isTodoDone=true).
- Delete a todo task from the system.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database


## Getting Started

To run the ToDoApp locally, follow these steps:

1. Clone the repository: `git clone https://github.com/Omkar6627/assignments/tree/main%2B%2B/User%20management%20system`
2. Navigate to the project directory: `cd todo-app`
3. (Optional) If you are using an IDE, import the project as a Maven project.
4. Build the application: `mvn clean install`
5. Run the application: `mvn spring-boot:run`
6. The application will start, and you can access it at `http://localhost:8080`

## Configuration

The application configuration can be found in the `application.properties` file. You may need to modify the database connection settings, server port, or any other properties based on your requirements.

## Usage

Once the application is up and running, you can access the following endpoints:

- `/api/toDoApps` - View a list of all todo tasks (REST API).
- `/api/toDoApps/{id}` - View details of a specific todo task by its ID (REST API).
- `/api/toDoApps` - Create a new todo task (REST API).
- `/api/toDoApps/{id}` - Update an existing todo task's details (REST API).
- `/api/toDoApps/{id}/markDone` - Mark a todo task as completed (REST API).
- `/api/toDoApps/{id}` - Delete a todo task from the system (REST API).
- `/h2-console` - Access the H2 database console (Development only).
- `/` - Homepage (if applicable).

## Model

The `ToDoApp` model represents a todo task with the following attributes:

- `id` (Long): Unique identifier for the todo task.
- `todoName` (String): Name or description of the todo task.
- `isTodoDone` (Boolean): Indicates whether the todo task is completed (true) or not (false).

## API Documentation

API documentation is generated automatically using SpringDoc and can be accessed at `http://localhost:8080/swagger-ui.html` (when the application is running). It provides detailed information about the available REST endpoints, request parameters, and responses.

## Contributing

We welcome contributions to improve the ToDoApp. If you find any issues or want to add new features, please create a pull request, and we will review it together.


## Done by 

- Name: [neyazwakil](https://github.com/Neyazwakil/gitassign)

- Twitter: [neyazwakil2](https://twitter.com/your_twitter_id)
- github:  [neyazwakil8271](https://github.com/)

