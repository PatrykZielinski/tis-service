# Introduction

This simple service exposes the rest endpoint, that calls the external xkcd rest 
service and in the end returns a title of a comic.

# Endpoints

The following endpoints are exposed:
- swagger-ui under `/swagger-ui.html`
- actuator under `/actuator`
- tis restendpoint under `/tis/commit/title`

The tis endpoint can be invoked using swagger-ui or just directly.

# Configuration

The `xkcd.host.url` can be configured in application.properties or overwritten using java system property.
The following command can be used in Docker in order to overwrite system property `xkcd.host.url`:

`docker run -e "xkcd.host.url=https://newxkcd.com" -p 8080:8080 -d tis-service:${version}`

# Installation steps

In order to build the service please execute the following:
-  set DOCKER_HOME & DOCKER_CERT_PATH system environment variables </br> 
The following command prints out the docker variables `docker-machine env --shell cmd default`

- `mvn clean install`

# Execution

Please execute the following:
- `mvn docker:start`

# Termination

Please execute the following:
- `mvn docker:stop`

# Integration tests

The test `com.fti.tis.service.endpoint.TisEndpointIntegrationTest` asserts the answer from the exposed endpoint `/tis/commit/title` 
within the docker container. 