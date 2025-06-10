package org.contourgara;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByFilesController {
    private final ProbeContentType probeContentType;

    public ByFilesController(@Qualifier("byFiles") ProbeContentType probeContentType) {
        this.probeContentType = probeContentType;
    }

    @GetMapping("/probe-content-type/by-files")
    @ResponseStatus(HttpStatus.OK)
    public String probeContentType(@RequestParam("file-name") String fileName) {
        return probeContentType.execute(fileName);
    }
}
