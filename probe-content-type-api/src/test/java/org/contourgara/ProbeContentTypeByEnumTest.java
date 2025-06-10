package org.contourgara;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProbeContentTypeByEnumTest {
    @ParameterizedTest
    @CsvSource({
            "test.png, image/png",
            "test.jpeg, image/jpeg",
            "test.txt, text/plain",
            "てすと.png, image/png",
            "テスト（1）.png, image/png",
            "スペース　あり.png, image/png"
    })
    void ファイル名からContentTypeを取得できる(String fileName, String expected) throws Exception {
        // setup
        ProbeContentTypeByEnum sut = new ProbeContentTypeByEnum();

        // execute
        String actual = sut.execute(fileName);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
