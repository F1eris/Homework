import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostmanTests {

    @Test
    @DisplayName("GET Request")
    void getRequestTest(){
        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .when().get("/get")
                .then().log().body().statusCode(HttpStatus.SC_OK);
    }
}
