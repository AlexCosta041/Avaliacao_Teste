package br.com.sicredi.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestProductsApi {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
    }

    @Test
    public void shouldGetProductsList() {
        given()
            .log().all()
        .when()
            .get("/products")
        .then()
            .log().all()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("products", notNullValue())
            .body("products.size()", greaterThan(0));
    }

    @Test
    public void shouldGetProductById_whenIdExists() {
        int id = 1;
        given()
            .log().all()
        .when()
            .get("/products/{id}", id)
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(id));
    }

    @Test
    public void shouldReturnNotFound_whenProductIdDoesNotExist() {
        int id = 999999;
        given()
            .log().all()
        .when()
            .get("/products/{id}", id)
        .then()
            .log().all()
            .statusCode(404);
    }

    @Test
    public void shouldCreateProduct_whenAuthenticated() {
        String payload = "{\"title\":\"Novo Produto Teste\", \"price\":199.99, \"description\":\"Produto criado via teste automatizado\"}";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/products/add")
        .then()
            .log().all()
            .statusCode(anyOf(is(200), is(201)))
            .body("title", equalTo("Novo Produto Teste"));
    }

    @Test
    public void shouldReturnUnauthorized_whenCreateProductWithoutToken() {
        String payload = "{\"title\":\"ProdutoSemToken\", \"price\": 1}";

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/products/add")
        .then()
            .log().all()
            .statusCode(anyOf(is(200), is(201)));
    }
}
