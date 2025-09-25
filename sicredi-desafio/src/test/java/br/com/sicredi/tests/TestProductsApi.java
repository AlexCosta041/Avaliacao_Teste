package br.com.sicredi.tests;

import br.com.sicredi.base.ApiConfig;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestProductsApi extends ApiConfig {

    @Test
    public void shouldGetProductsList() {
        given()
        .when()
            .get("/products")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("products", notNullValue())
            .body("products.size()", greaterThan(0));
    }

    @Test
    public void shouldGetProductById_whenIdExists() {
        int id = 1;
        given()
        .when()
            .get("/products/{id}", id)
        .then()
            .statusCode(200)
            .body("id", equalTo(id));
    }

    @Test
    public void shouldReturnNotFound_whenProductIdDoesNotExist() {
        int id = 999999;
        given()
        .when()
            .get("/products/{id}", id)
        .then()
            .statusCode(anyOf(is(404), is(400)));
    }

    @Test
    public void shouldCreateProduct_whenAuthenticated() {
        String token =
            given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"kminchelle\",\"password\":\"0lelplR\"}")
            .when()
                .post("/auth/login")
            .then()
                .statusCode(anyOf(is(200), is(201)))
                .extract().path("token");

        String payload = "{\"title\":\"Novo Produto Teste\", \"price\": 199.99, \"description\": \"Produto criado via teste automatizado\" }";

        given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + token)
            .body(payload)
        .when()
            .post("/products/add")
        .then()
            .statusCode(anyOf(is(200), is(201)))
            .body("title", equalTo("Novo Produto Teste"));
    }

    @Test
    public void shouldReturnUnauthorized_whenCreateProductWithoutToken() {
        String payload = "{\"title\":\"ProdutoSemToken\", \"price\": 1 }";

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/products/add")
        .then()
            .statusCode(anyOf(is(401), is(403)));
    }
}
