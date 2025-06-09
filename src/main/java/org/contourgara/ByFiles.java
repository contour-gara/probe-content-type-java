package org.contourgara;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByFiles {
    public String execute(String fileName) throws IOException {
        Path path = new File(fileName).toPath();
        return Files.probeContentType(path);
    }
}
