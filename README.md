# Java Gradle DevOps Application

## Overview

The **Java Gradle DevOps Application** is a lightweight, clean, and beginner-friendly Java Spring Boot REST API built to demonstrate core DevOps practices for **TASK 3: Java Application using Gradle**.

This project establishes the foundation for modern CI/CD by showcasing:
* Build automation using the **Gradle Wrapper**
* Efficient dependency management via Gradle and Maven Central
* Automated unit and integration testing with **JUnit 5** and **Spring Boot Test**
* Packaging and generation of standalone, executable JAR artifacts
* Preparation for automated pipeline integration with **Jenkins**

> **Note**: Jenkins CI/CD configuration will be integrated in the next phase. This repository contains the fully functional, self-contained Java backend and Gradle build infrastructure ready to be built on an Ubuntu Jenkins Agent.

---

## Technologies

* **Java**: 21 (LTS)
* **Spring Boot**: 3.3.4
* **Build System**: Gradle 8.8 (using Gradle Wrapper)
* **Testing Framework**: JUnit 5 & Spring Boot Test (MockMvc)
* **CI/CD Platform**: Jenkins *(to be configured in the next phase)*
* **Target Environment**: Ubuntu Linux (Dell Latitude 5400 Agent) & Windows (Controller)

---

## API Endpoints

The application exposes three clean REST API endpoints:

### 1. Root Endpoint

* **URL**: `/`
* **Method**: `GET`
* **Response Code**: `200 OK`
* **Content-Type**: `application/json`
* **Sample Response**:
  ```json
  {
    "message": "Java Gradle DevOps Application is running",
    "version": "1.0.0"
  }
  ```

---

### 2. Hello Endpoint

* **URL**: `/api/hello`
* **Method**: `GET`
* **Response Code**: `200 OK`
* **Content-Type**: `application/json`
* **Sample Response**:
  ```json
  {
    "message": "Hello from Java Gradle Application"
  }
  ```

---

### 3. Application Information Endpoint

* **URL**: `/api/info`
* **Method**: `GET`
* **Response Code**: `200 OK`
* **Content-Type**: `application/json`
* **Sample Response**:
  ```json
  {
    "application": "Java Gradle DevOps App",
    "version": "1.0.0",
    "java": "21",
    "buildTool": "Gradle"
  }
  ```

---

## Project Structure

```text
java-gradle-devops-app/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── javagradledevops/
│   │   │               ├── JavaGradleDevOpsApplication.java
│   │   │               └── controller/
│   │   │                   └── DevOpsController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── javagradledevops/
│                       └── DevOpsControllerTest.java
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── settings.gradle
```

---

## Build

The project includes the Gradle Wrapper (`gradlew` / `gradlew.bat`), meaning Gradle does not need to be installed globally on the system or Jenkins agent.

### On Linux / macOS / Jenkins Agent:
```bash
./gradlew clean build
```

### On Windows:
```bat
gradlew.bat clean build
```

To build only the executable JAR artifact:
```bash
./gradlew bootJar
```

---

## Test

Run automated unit and integration tests using JUnit 5:

### On Linux / macOS / Jenkins Agent:
```bash
./gradlew test
```

### On Windows:
```bat
gradlew.bat test
```

Test reports are automatically generated in HTML format inside:
```text
build/reports/tests/test/index.html
```

---

## Run

### Option 1: Run with Gradle BootRun
```bash
# Linux / macOS
./gradlew bootRun

# Windows
gradlew.bat bootRun
```

### Option 2: Run the Executable JAR
```bash
java -jar build/libs/java-gradle-devops-app-1.0.0.jar
```

The application will start on port `8085`.

Verify the application using `curl`:
```bash
curl http://localhost:8085/
curl http://localhost:8085/api/hello
curl http://localhost:8085/api/info
```

---

## Build Artifact

When the build completes, Gradle packages the application into a standalone executable Spring Boot JAR inside:
```text
build/libs/java-gradle-devops-app-1.0.0.jar
```

This self-contained JAR includes all necessary runtime dependencies and an embedded Tomcat web server.

---

## Future Jenkins CI/CD Pipeline

In the next phase of the DevOps assignment, this application will be integrated into the existing Jenkins architecture:

```text
Windows Laptop (Jenkins Controller)
        │
        │ SSH Remoting
        ↓
Ubuntu Dell Latitude 5400 (Jenkins Agent: ubuntu-agent-01)
```

The planned Jenkins automated pipeline workflow:

```text
GitHub (Source Repository)
   ↓
Jenkins Controller (Triggers Build Job)
   ↓
Ubuntu Jenkins Agent (Executes Pipeline Workspace)
   ↓
Gradle Wrapper (Resolves Build Tool)
   ↓
Dependency Resolution (Maven Central via build.gradle)
   ↓
Build (Compiles Java 21 Source Code)
   ↓
Automated Tests (Executes JUnit 5 Suite)
   ↓
JAR Artifact (Generates java-gradle-devops-app-1.0.0.jar)
   ↓
Deployment (Deploys Executable JAR to Target Environment)
   ↓
Running Java Application (Healthy REST API on Port 8085)
```

> **Next Step**: Connect this repository to the Jenkins Controller, configure a Jenkinsfile / Freestyle/Pipeline job executing on `ubuntu-agent-01`, and automate the test, build, and deployment steps.
