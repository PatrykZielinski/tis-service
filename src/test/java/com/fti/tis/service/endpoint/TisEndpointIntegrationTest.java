package com.fti.tis.service.endpoint;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static com.fti.tis.service.util.DockerTestUtil.resolveBaseUri;
import static com.fti.tis.service.util.DockerTestUtil.resolvePort;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TisEndpointIntegrationTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = resolvePort();
        RestAssured.baseURI = resolveBaseUri();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void ensureComicEndpointIsAvailable() {
        given().when().get("/tis/comic/title").then() //
                .assertThat().statusCode(HttpStatus.OK.value()) //
                .assertThat().body(containsString("the title of today’s XKCD comic was"));
    }
}
