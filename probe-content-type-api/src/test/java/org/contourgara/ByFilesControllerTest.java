package org.contourgara;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ByFilesController.class)
class ByFilesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean("byFiles")
    ProbeContentType probeContentType;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @ParameterizedTest
    @CsvSource({
            "test.png, image/png",
            "test.jpeg, image/jpeg"
    })
    void Filesによる実装のエンドポイントがGETされた場合MIMEタイプの文字列を返す(String filename, String expected) {
        // setup
        doReturn(expected).when(probeContentType).execute(filename);

        // execute & assert
        given()
                .when()
                .get("/probe-content-type/by-files?file-name=" + filename)
                .then()
                .statusCode(200)
                .body(equalTo(expected));
    }
}
