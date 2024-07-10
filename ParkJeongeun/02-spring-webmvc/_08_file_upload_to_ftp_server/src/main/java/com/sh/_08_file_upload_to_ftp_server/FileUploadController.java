package com.sh._08_file_upload_to_ftp_server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @PostMapping("/upload")
    public String upload(@RequestParam("upFile") List<MultipartFile> upFiles) throws IOException {
        // 1. 파일업로드 처리
        List<FileDto> list = new ArrayList<>();
        for (MultipartFile file : upFiles) {
            if (!file.isEmpty()) {
                FileDto fileDto = fileUploadService.upload(file);
                list.add(fileDto);
            }
        }
        log.debug("list = {}", list);
        // 2. 업로드한 파일명/저장된 파일명 정보를 DB 등록

        return "redirect:/";
    }
}