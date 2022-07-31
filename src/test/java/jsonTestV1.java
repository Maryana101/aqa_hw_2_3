import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class jsonTestV1 {
    @Test
    void shouldTestJsonBody() {
        JSONObject requestBody = new JSONObject()
                .put("bar1", "foo1")
                .put("bar2", "foo2")
                .put("bar3", "foo3");

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com/")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                // Выполняемые действия
                .when()
                .post("/post")
                 // Проверки
                .then()
                .statusCode(403)
                .body("data.bar1", equalTo("foo1"))
                .body("data.bar3", equalTo("foo2"))
                .header("Content-Type","application/json; charset=utf-8")
        ;

    }
}
