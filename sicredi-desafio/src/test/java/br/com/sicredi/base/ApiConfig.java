package br.com.sicredi.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiConfig {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
