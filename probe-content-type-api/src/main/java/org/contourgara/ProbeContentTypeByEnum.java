package org.contourgara;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("byEnum")
public class ProbeContentTypeByEnum implements ProbeContentType {
    @Override
    public String execute(String fileName) {
        return AllowedContentType.fromFileName(fileName).mimeType;
    }

    @RequiredArgsConstructor
    private enum AllowedContentType {
        PNG(".png", "image/png"),
        JPEG(".jpeg", "image/jpeg"),
        JPG(".jpg", "image/jpg"),
        TEXT(".txt", "text/plain"),;

        private final String extension;
        private final String mimeType;

        static AllowedContentType fromFileName(String fileName) {
            for (AllowedContentType allowedContentType : AllowedContentType.values()) {
                if (fileName.endsWith(allowedContentType.extension)) return allowedContentType;
            }
            throw new IllegalArgumentException("Unsupported file type: " + fileName);
        }
    }
}
