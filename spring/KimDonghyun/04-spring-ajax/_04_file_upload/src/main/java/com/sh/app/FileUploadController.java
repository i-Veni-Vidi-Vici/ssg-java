package com.sh.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
@Slf4j
public class FileUploadController {

    @PostMapping("/formdata")
    @ResponseBody
    public String postFileUploadTest(
            MyDto myDto, 
            @RequestParam(name = "upFile", required = false) List<MultipartFile> multipartFiles) {
        log.debug("myDto = {}", myDto);
        multipartFiles.forEach((file) -> log.debug("upFile = {} {}", file.getOriginalFilename(), file.getSize()));
        
        // 파일 저장 요청은 기존과 동일하다.

        return "Success";

    }
}