package com.example.restBookerApi.utis.validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseValidation {
    private static final String DATE_PROPERTY_FORMAT = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String ERROR_MESSAGE = "Bad Credentials";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json";
    private final Map<String, String> schemaFileNames = new HashMap<>();

    public ResponseValidation() {
        schemaFileNames.put("createToken", "createTokenResponseSchema.json");
        schemaFileNames.put("createBooking", "createBookingResponseSchema.json");
        schemaFileNames.put("getBookingById", "getBookingByIdResponseSchema.json");
        schemaFileNames.put("getBooking", "getBookingResponseSchema.json");
        schemaFileNames.put("updateBooking", "updateBookingResponseSchema.json");
        schemaFileNames.put("partialUpdateBooking", "partialUpdateBookingResponseSchema.json");
    }

    public void validateResponseHeaders(Response response) {
        Assertions.assertThat(response.contentType())
                .as(AssertionMessages.WRONG_CONTENT_TYPE)
                .contains(APPLICATION_JSON_CHARSET_UTF_8);
    }

    public void validateResponseStatusCode(final Response response, int expectedStatusCode) {
        Assertions.assertThat(response.statusCode())
                .as(AssertionMessages.INVALID_STATUS_CODE)
                .isEqualTo(expectedStatusCode);
    }

    public void validateResponseErrorMessage(final Response response) {
        Assertions.assertThat(response.jsonPath().getString("reason"))
                .as(AssertionMessages.ERROR_MESSAGE_NOT_DISPLAYED)
                .isEqualTo(ERROR_MESSAGE);
    }

    public void validateResponseDatePropertyFormat(final Response response, String date) {
        Assertions.assertThat(response.jsonPath().getString(date))
                .as(AssertionMessages.INVALID_DATE_FORMAT)
                .isEqualTo(DATE_PROPERTY_FORMAT);
    }

    public void validateResponseBodyIsEmptyArray(final Response response) {
        JsonPath jsonPath = response.jsonPath();
        List<Object> responseBodyList = jsonPath.getList("");

        Assertions.assertThat(responseBodyList)
                .as(AssertionMessages.RESPONSE_BODY_EMPTY)
                .isEmpty();
    }

    public void validateResponseBodySchema(final Response response, String responseType) {
        try {
            response.then().assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(getResponseSchemaFileName(responseType)));
        } catch (AssertionError e) {
            throw new AssertionError(AssertionMessages.RESPONSE_BODY_SCHEMA_MISMATCH);
        }
    }

    private String getResponseSchemaFileName(String responseType) {
        String schemaFileName = schemaFileNames.get(responseType);
        if (schemaFileName == null) {
            throw new NullPointerException(AssertionMessages.UNKNOWN_RESPONSE_TYPE);
        }
        return schemaFileName;
    }
}


