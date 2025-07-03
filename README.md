# Lynx Plugin

This project is a Minecraft plugin built using Maven. The plugin targets the
Paper API.

## Build Information

The project depends on `paper-api` version `1.20.1-R0.1-SNAPSHOT`, which is
declared with `scope` set to `provided` in the Maven configuration.

## Building

Ensure that Java 17 and Maven 3 are installed. To build the plugin JAR run:

```bash
mvn clean package
```

The compiled JAR will be located in `target/`. Since the Paper API is marked as
provided, it needs to be available on the server at runtime.

## Running Tests

Unit tests can be executed with:

```bash
mvn test
```

This repository uses JUnit 5 for testing.
