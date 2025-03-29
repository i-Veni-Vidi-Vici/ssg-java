package com.sh._05_handler_interceptor;

import org.springframework.web.bind.annotation.PostMapping;

public class FileUploadController {
    @PostMapping("/singleFile")
    public String singleFile() {
        return "result";
    }
}
