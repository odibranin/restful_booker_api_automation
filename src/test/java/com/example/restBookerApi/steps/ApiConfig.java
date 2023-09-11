package com.example.restBookerApi.steps;

import com.example.restBookerApi.utis.authentication.ApiConstants;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public abstract class ApiConfig {
    public static Response sendRequest(String method, String path, Object body) {
        return given()
                .spec(requestSpec(body))
                .when()
                .request(method, path);
    }

    public static Response sendRequest(String method, String path, String bookingId, Object body) {
        return given()
                .spec(requestSpec(body))
                .when()
                .request(method, path + bookingId);
    }

    private static RequestSpecification requestSpec(Object body) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(ApiConstants.BASE_URL)
                .setAuth(setBasicAuthScheme())
                .addHeader("Content-Type", ContentType.JSON.toString())
                .build();

        if (body != null) {
            requestSpec = requestSpec.body(body);
        }
        return requestSpec;
    }

    private static BasicAuthScheme setBasicAuthScheme() {
        final BasicAuthScheme authScheme = new BasicAuthScheme();
        authScheme.setUserName(ApiConstants.VALID_USERNAME);
        authScheme.setPassword(ApiConstants.VALID_PASSWORD);
        return authScheme;
    }
}
