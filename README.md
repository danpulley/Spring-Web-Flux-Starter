# Spring web client MBO

This application utilizes the Pokémon api https://pokeapi.co/ and can be interchanged with other apis.

The project uses Spring WebFlux to demonstrate How we can reactively make api calls

Mono: sample does a basic call to the pokemon api with a given name

Flux: sample does a call from a list of names given. The Flux output will not come back in the order of the names
as the calls being made are async so whichever call completes first will get emitted first

## Requirements

For building and running the application you need:

- [JDK 1.17]

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

best way is to run the following 

```shell
./gradlew :bootRun in CLI
```

