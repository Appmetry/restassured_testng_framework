# API Testing Framework with RestAssured, TestNG, Maven, and Extent Report

Welcome to our API testing framework that leverages RestAssured, TestNG, Maven, and Extent Report to automate API testing. This framework allows you to easily write, run, and report on your API tests, ensuring the reliability and functionality of your web services.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setting Up the Project](#setting-up-the-project)
- [Adding Dependencies](#adding-dependencies)
- [Writing API Tests](#writing-api-tests)
- [Generating Extent Reports](#generating-extent-reports)
- [Running Tests](#running-tests)
- [Viewing Extent Reports](#viewing-extent-reports)
- [Contributing](#contributing)


## Prerequisites

Before you get started with this project, make sure you have the following prerequisites in place:

- **Java**: Ensure that you have Java installed on your machine. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- **Maven**: Install Maven to manage your project dependencies and build processes. You can download Maven [here](https://maven.apache.org/download.cgi).

- **IDE**: You can use any Java IDE of your choice, such as IntelliJ IDEA or Eclipse.

## Setting Up the Project

To set up the project, you can use Maven to create a basic project structure:

```bash
mvn archetype:generate -DgroupId=com.yourcompany -DartifactId=api-test-framework -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


