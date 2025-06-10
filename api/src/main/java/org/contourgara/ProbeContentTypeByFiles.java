package org.contourgara;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service("byFiles")
public class ProbeContentTypeByFiles implements ProbeContentType {
    public String execute(String fileName) {
        Path path = new File(fileName).toPath();
        try {
            return Files.probeContentType(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
