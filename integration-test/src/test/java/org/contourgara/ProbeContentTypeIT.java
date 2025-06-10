package org.contourgara;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProbeContentTypeIT {
    @BeforeAll
    static void setUpAll() {
        baseURI = "http://localhost:8080";
    }

    @Test
    void Filesの実装に日本語ファイル名が渡された場合500が返る() {
        // execute & assert
        given()
                .when()
                .get("/probe-content-type/by-files?file-name=日本語.png")
                .then()
                .statusCode(500);
    }

    @Test
    void Enumの実装に日本語ファイル名が渡された場合200とMIMEタイプが返る() {
        // execute & assert
        given()
                .when()
                .get("/probe-content-type/by-enum?file-name=日本語.png")
                .then()
                .statusCode(200)
                .body(equalTo("image/png"));
    }
}
