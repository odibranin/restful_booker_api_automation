package com.example.restBookerApi.steps;

import com.example.restBookerApi.utis.authentication.ApiConstants;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public abstract class ApiConfig {
    public static Response sendRequest(String method, String path, Object body, boolean auth) {
        return given()
                .spec(requestSpec(body, auth))
                .when()
                .request(method, path);
    }

    public static Response sendRequest(String method, String path, String bookingId, Object body, boolean auth) {
        return given()
                .spec(requestSpec(body, auth))
                .when()
                .request(method, path + bookingId);
    }

    private static RequestSpecification requestSpec(Object body, boolean auth) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(ApiConstants.BASE_URL)
                .addHeader("Content-Type", ContentType.JSON.toString());

        if (body != null) {
            requestSpecBuilder.setBody(body);
        }

        if (auth) {
            requestSpecBuilder.setAuth(setBasicAuthScheme());
        }

        return requestSpecBuilder.build();
    }

    private static BasicAuthScheme setBasicAuthScheme() {
        final BasicAuthScheme authScheme = new BasicAuthScheme();
        authScheme.setUserName(ApiConstants.VALID_USERNAME);
        authScheme.setPassword(ApiConstants.VALID_PASSWORD);
        return authScheme;
    }
}
