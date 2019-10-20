# Introduction

This simple service exposes the rest endpoint, that calls the external xkcd rest 
service and in the end returns a title of a comic.

# Endpoints

The following endpoints are exposed:
- swagger-ui under `/swagger-ui.html`
- actuator under `/actuator`
- tis comic rest endpoint under `/tis/commit/title`

It is recommended to call the tis rest service using the swagger-ui.

# Configuration

The `xkcd.host.url` can be configured in application.properties or overwritten using java system property.
The `xkcd.host.url` originally points to `https://xkcd.com`

# Installation steps

In order to build the service please execute the following:
- `mvn clean install`
- set dockerHost variable in pom.xml 

# Execution


