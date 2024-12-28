# Spring Boot JSON
## Introduction
This repository was meant to have an example of JSON processing in a Spring Boot context.
## Current state
The current state of the repository contains tests where the JSON processing is implemented.
## Project Structure (should be state)
Several cases can be used when processing a JSON file including:
* API (programmatic) way:
  * Read a JSON file from the file system, traverse it node by node, and extract some data into an object.
  * Create a JSON file with the API and save it to a file.
* Object-Binding way:
  * Read the JSON file through the Jackson API by unmarshalling.
  * Write the JSON file through the Jackson API by marshaling.
## Links
* https://www.youtube.com/watch?v=cw0TfpcUkao
* https://www.youtube.com/watch?v=EumLbf8WjnY
* https://www.baeldung.com/jackson-annotations
* https://www.baeldung.com/jackson-advanced-annotations
