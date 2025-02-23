
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PostmanTests {

    private RequestSpecification spec;

    @BeforeEach
    void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://postman-echo.com")
                .build();
    }

    @Test
    @DisplayName("GET Request")
    void getRequestTest() {
        given()
                .spec(spec)
                .queryParams("foo1", "bar1", "foo2", "bar2")
                .log().uri()
                .when().get("/get")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("POST Raw Text")
    void postRawTextTest() {
        String expectedText = "This is expected to be sent back as part of response body.";

        given()
                .spec(spec)
                .contentType(ContentType.TEXT)
                .body(expectedText)
                .log().uri()
                .log().body()
                .when().post("/post")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(expectedText));
    }

    @Test
    @DisplayName("POST Form Data")
    void postFormDataTest() {
        given()
                .spec(spec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams("foo1", "bar1", "foo2", "bar2")
                .log().uri()
                .log().parameters()
                .when().post("/post")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("PUT Request")
    void putRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";
        given()
                .spec(spec)
                .contentType(ContentType.TEXT)
                .body(expectedText)
                .log().uri()
                .log().body()
                .when().put("/put")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(expectedText));
    }

    @Test
    @DisplayName("PATCH Request")
    void patchRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";
        given()
                .spec(spec)
                .contentType(ContentType.TEXT)
                .body(expectedText)
                .log().uri()
                .log().body()
                .when().patch("/patch")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(expectedText));
    }

    @Test
    @DisplayName("DELETE Request")
    void deleteRequestTest() {
        String expectedText = "This is expected to be sent back as part of response body.";
        given()
                .spec(spec)
                .contentType(ContentType.TEXT)
                .body(expectedText)
                .log().uri()
                .log().body()
                .when().delete("/delete")
                .then()
                .log().status()
                .log().body(false)
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo(expectedText));
    }
}
