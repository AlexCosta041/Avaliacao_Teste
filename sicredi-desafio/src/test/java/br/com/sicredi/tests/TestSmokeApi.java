package br.com.sicredi.tests;

import br.com.sicredi.base.ApiConfig;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestSmokeApi extends ApiConfig {

    @Test
    public void shouldReturnStatusOkOnHealthEndpoint() {
        given()
        .when()
            .get("/test")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("status", equalTo("ok"))
            .body("method", equalTo("GET"));
    }

    @Test
    public void shouldReturnUsersListAndContainImportantFields() {
        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("users", notNullValue())
            .body("users.size()", greaterThan(0))
            .body("users[0]", hasKey("username"))
            .body("users[0]", hasKey("password"));
    }

    @Test
    public void shouldAuthenticateAndReturnToken_whenCredentialsValid() {
        String username = "emilys";
        String password = "emilyspass";

        given()
            .contentType(ContentType.JSON)
            .body(String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password))
        .when()
            .post("/auth/login")
        .then()
            .statusCode(anyOf(is(200), is(201)))
            .body("token", notNullValue())
            .body("username", equalTo(username));
    }

    @Test
    public void shouldFailAuthenticationWithInvalidCredentials() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"username\":\"invalid\",\"password\":\"wrong\"}")
        .when()
            .post("/auth/login")
        .then()
            .statusCode(anyOf(is(400), is(401), is(403)));
    }
}
