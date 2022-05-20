package tests;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void checkingStarshipsInfo() {
        log.info("Checking starships");
        given().
                when().
                get("https://swapi.dev/api/starships/10")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Millennium Falcon"))
                .body("cost_in_credits", equalTo("100000"))
                .body("length", equalTo("34.37"))
                .body("pilots", hasSize(4));
    }
}