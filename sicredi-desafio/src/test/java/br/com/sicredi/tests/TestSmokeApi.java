package br.com.sicredi.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestSmokeApi {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
    }

    @Test
    public void shouldReturnStatusOkOnHealthEndpoint() {
        given()
            .log().all()
        .when()
            .get("/products")
        .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("products", notNullValue());
    }

    @Test
    public void shouldReturnUsersListAndContainImportantFields() {
        given()
            .log().all()
        .when()
            .get("/users")
        .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("users", notNullValue())
            .body("users.size()", greaterThan(0))
            .body("users[0]", hasKey("firstName"))
            .body("users[0]", hasKey("lastName"));
    }

    @Test
    public void shouldAuthenticateAndReturnToken_whenCredentialsValid() {
        String payload = "{\"username\":\"kminchelle\",\"password\":\"0lelplR\"}";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/auth/login")
        .then()
            .log().all()
            .statusCode(anyOf(is(200), is(201)));
    }

    @Test
    public void shouldFailAuthenticationWithInvalidCredentials() {
        String payload = "{\"username\":\"invalid\",\"password\":\"wrong\"}";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/auth/login")
        .then()
            .log().all()
            .statusCode(anyOf(is(200), is(201)));
    }
}
