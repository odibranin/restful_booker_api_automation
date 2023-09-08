package api.steps;

import api.utis.authentication.ApiConstants;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public abstract class ApiConfig {
    public static Response sendRequest(String method, String path) {
        RequestSpecification requestSpec = requestSpec();
        return given()
                .spec(requestSpec)
                .when()
                .request(method, path);
    }

    public static Response sendRequest(String method, String path, String bookingId, Object body) {
        RequestSpecification requestSpec = requestSpec();

        if (body != null) {
            requestSpec = requestSpec.body(body);
        }

        return given()
                .spec(requestSpec)
                .when()
                .request(method, path + bookingId);
    }

    protected static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ApiConstants.BASE_URL)
                .setAuth(setBasicAuthScheme())
                .addHeader("Content-Type", ContentType.JSON.toString())
                .addHeader("Accept", ContentType.JSON.toString())
                .build();
    }

    private static BasicAuthScheme setBasicAuthScheme() {
        final BasicAuthScheme authScheme = new BasicAuthScheme();
        authScheme.setUserName(ApiConstants.VALID_USERNAME);
        authScheme.setPassword(ApiConstants.VALID_PASSWORD);
        return authScheme;

    }
}
