package org.contourgara;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProbeContentTypeApplicationTest {
    @Autowired
    ByFilesController byFilesController;

    @Test
    void contextLoads() {
        // assert
        assertThat(byFilesController).isNotNull();
    }
}
